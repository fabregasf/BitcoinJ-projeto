package com.arquiteto.btc;

import com.arquiteto.elements.ScriptTest;
import com.arquiteto.elements.TransactionTest;

public class BtcFactory {

    private static BtcFactory instance;
    private BtcFactory(){}

    public static BtcFactory getInstance() {
        if (instance == null) {
            instance = new BtcFactory();
        }
        return instance;
    }

    public ScriptTest novoScript(){
        return new ScriptTest();
    }

    public TransactionTest novaTransacao(){
        return new TransactionTest();
    }


}
