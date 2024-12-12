package com.bitwormhole.passwordgm;

import androidx.test.ext.junit.runners.AndroidJUnit4;

import com.bitwormhole.passwordgm.contexts.ContextScope;
import com.bitwormhole.passwordgm.data.ids.KeyAlias;
import com.bitwormhole.passwordgm.security.KeyPairHolder;
import com.bitwormhole.passwordgm.security.KeyPairManagerImpl;
import com.bitwormhole.passwordgm.security.KeySelector;
import com.bitwormhole.passwordgm.utils.HashUtils;
import com.bitwormhole.passwordgm.utils.Logs;

import org.junit.Test;
import org.junit.runner.RunWith;

import java.security.KeyPair;
import java.security.PrivateKey;
import java.security.PublicKey;


@RunWith(AndroidJUnit4.class)
public class KeyPairManagerTest {

    @Test
    public void useKeyPairManager() {

        KeyAlias alias = KeySelector.alias(ContextScope.TEST, "test-1");
        KeyPairManagerImpl kpm = new KeyPairManagerImpl();
        KeyPairHolder h = kpm.get(alias);
        if (!h.exists()) {
            h.create();
        }
        KeyPair kp = h.fetch();

        PrivateKey pri = kp.getPrivate();
        PublicKey pub = kp.getPublic();
        String finger = computeFingerprint(h);

        Logs.info("private-key: " + pri);
        Logs.info("public--key: " + pub);
        Logs.info("public-key-sha1-fingerprint: " + finger);
        Logs.info("public-key-alias: " + h.alias());
    }

    @Test
    public void useCURD() {

        KeyAlias alias = KeySelector.alias(ContextScope.TEST, "test-2");
        KeyPairManagerImpl kpm = new KeyPairManagerImpl();
        KeyPairHolder h1 = kpm.get(alias);
        if (!h1.exists()) {
            h1.create();
        }

        KeyPairHolder h2 = kpm.get(alias);
        String f1 = computeFingerprint(h1);
        String f2 = computeFingerprint(h2);


        Logs.info("public-key-finger1: " + f1);
        Logs.info("public-key-finger2: " + f2);
        Logs.info("alias: " + alias);
    }

    private static String computeFingerprint(KeyPairHolder h) {
        PublicKey pub = h.fetch().getPublic();
        byte[] pubKeyData = pub.getEncoded();
        return HashUtils.hexSum(pubKeyData, HashUtils.SHA1);
    }
}
