package com.arquiteto.elements;/* ScriptBuilder sendo chamado para criação de um programa Script
Observar a classe Base TransactionTest, ela encapsula um "Script padrão"

Aqui eu tenho: address, ECkey, sign, 

Tem que ter 2 opcodes + a hash + 2 opcodes:
Console.WriteLine(mainNetAddress.ScriptPubKey); 
Exemplo: 
OP_DUP OP_HASH160 14836dbe7f38c5ac3d49e8d790af808a4ee9edcf OP_EQUALVERIFY OP_CHECKSIG

Tentar montar um script com recipiente com chave publica (ECkey). P2PKH
*/

import okhttp3.Address;
import org.bitcoinj.core.ECKey;
import org.bitcoinj.crypto.TransactionSignature;
import org.bitcoinj.script.Script;
import org.bitcoinj.script.ScriptBuilder;

import java.math.BigInteger;

public class ScriptTest extends ScriptBuilder {

    private Script myinputscript, myoutputscript;
    private Address address;
    private ECKey eckey;
    private ScriptBuilder builder;
    private TransactionSignature dummySig;

    public ScriptTest(){
        this.builder = new ScriptBuilder();
        this.dummySig = TransactionSignature.dummy(); // mudar a assinatura
        // usando parametros
        this.eckey = new ECKey();
        System.out.println(this.eckey.toString());

        this.myinputscript = this.ScriptInput(dummySig, eckey);
        this.myoutputscript = this.ScriptOutput(myinputscript);

    }

    // BIP 16
    public Script ScriptInput(TransactionSignature signature, org.bitcoinj.core.ECKey eckey){
        myinputscript = createInputScript(signature, eckey);
        return myinputscript;
    }
    // BIP16
    public Script ScriptOutput(Script redeemscript){
        myoutputscript = createP2SHOutputScript(redeemscript);
        return myoutputscript;
    }


    public String toString(){
        return this.getClass().toString();

    }
}