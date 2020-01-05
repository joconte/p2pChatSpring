package fr.epsi.jconte.p2pChatSpring.utility;

import java.io.*;
import java.security.Key;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.util.Base64;

public class CreateRSAKeys {

    static private void writeBinary(OutputStream out,Key key)
            throws java.io.IOException
    {
        out.write(key.getEncoded());
    }

    static public void create(int keySize, String outFile) throws Exception
    {
        String algo = "RSA";

        KeyPairGenerator kpg = KeyPairGenerator.getInstance(algo);

        /* initialize with keySize: typically 2048 for RSA */
        kpg.initialize(keySize);
        KeyPair kp = kpg.generateKeyPair();

        OutputStream out = null;
        try {
            System.err.println("Private key format: " +
                    kp.getPrivate().getFormat());
            out = new FileOutputStream(outFile + ".key");
            writeBinary(out, kp.getPrivate());
            out.close();

            System.err.println("Public key format: " +
                    kp.getPublic().getFormat());
            out = new FileOutputStream(outFile + ".pub");
            writeBinary(out, kp.getPublic());
        } finally {
            if ( out != null ) out.close();
        }

    }
}
