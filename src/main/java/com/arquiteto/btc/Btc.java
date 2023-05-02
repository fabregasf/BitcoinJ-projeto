/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.arquiteto.btc;

import com.arquiteto.elements.ScriptTest;
import com.arquiteto.elements.TransactionTest;
import org.bitcoinj.core.ECKey;
import org.bitcoinj.core.NetworkParameters;
import org.bitcoinj.params.MainNetParams;
import org.bitcoinj.script.Script;
import org.bitcoinj.utils.BriefLogFormatter;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Usuario
 */
public class Btc {

    public static void main(String[] args)  throws Exception {

        BriefLogFormatter.init();
        System.out.println("Initializing Wallet and Network");
        final NetworkParameters params = MainNetParams.get();

        TransactionTest test = new TransactionTest();
        test.getInputOutputs(test);

        BtcFactory.getInstance().novoScript();



    }
}
