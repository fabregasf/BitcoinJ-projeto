/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.arquiteto.operations;

import java.io.File;
import org.bitcoinj.core.ECKey;
import org.bitcoinj.core.NetworkParameters;
import org.bitcoinj.kits.WalletAppKit;

/**
 *
 * @author Usuario
 */
public class SimpleWallet {
    
    WalletAppKit kit;
    
    public SimpleWallet(){}
    
    public SimpleWallet(NetworkParameters params, File arquivo, String filePrefix){
        
        kit = new WalletAppKit(params, arquivo, filePrefix) {
            @Override
            protected void onSetupCompleted() {
                // This is called in a background thread after startAndWait is called, as setting up various objects
                // can do disk and network IO that may cause UI jank/stuttering in wallet apps if it were to be done
                // on the main thread.
                if (wallet().getKeyChainGroupSize() < 1)
                    wallet().importKey(new ECKey()); 
            }
        };
        // Download the block chain and wait until it's done.
        kit.startAsync();
        kit.awaitRunning();
        
        System.out.println(kit.wallet() +" - "+ kit.peerGroup());
    }
}
