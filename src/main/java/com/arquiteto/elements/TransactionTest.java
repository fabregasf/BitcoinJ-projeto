package com.arquiteto.elements;

import org.bitcoinj.core.Transaction;
import org.bitcoinj.core.TransactionInput;
import org.bitcoinj.core.TransactionOutput;
import org.bitcoinj.params.MainNetParams;

public class TransactionTest extends Transaction {

    private Transaction transaction;

    public TransactionTest(){
        super(MainNetParams.get());

    }


    public void getInputOutputs(Transaction tx){
        while(!tx.getInputs().isEmpty()){
            for (TransactionInput ti : tx.getInputs()) {  // show address and funds
                System.out.println("in scriptsig:" + ti.getScriptSig());
                System.out.println("in connected output:" + ti.getConnectedOutput());
            }
            for (TransactionOutput to : tx.getOutputs()) {
                // sometimes this line throws: org.bitcoinj.script.ScriptException: Cannot cast this script to an address
                System.out.println("out address:" + to.getScriptPubKey().getToAddress(MainNetParams.get()));
                System.out.println("out value:" + to.getValue().toString());
            }
        }
    }

    public byte[] serialize(){
        return this.transaction.bitcoinSerialize();
    }

    public boolean isPending(){
        return this.transaction.isPending();
    }

}
