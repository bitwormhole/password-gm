package com.bitwormhole.passwordgm.data.repositories;

import com.bitwormhole.passwordgm.contexts.ContextScope;

import java.security.KeyPair;

import javax.crypto.SecretKey;

public class RepositoryContext {

    private SecretKey secretKey;
    private KeyPair keyPair;
    private ContextScope scope;

    private RepositoryLayout layout;
    private Repository repository;

    public RepositoryContext() {
    }

    public Repository getRepository() {
        return repository;
    }

    public void setRepository(Repository repository) {
        this.repository = repository;
    }

    public ContextScope getScope() {
        return scope;
    }

    public void setScope(ContextScope scope) {
        this.scope = scope;
    }

    public KeyPair getKeyPair() {
        return keyPair;
    }

    public void setKeyPair(KeyPair keyPair) {
        this.keyPair = keyPair;
    }

    public SecretKey getSecretKey() {
        return secretKey;
    }

    public void setSecretKey(SecretKey secretKey) {
        this.secretKey = secretKey;
    }

    public RepositoryLayout getLayout() {
        return layout;
    }

    public void setLayout(RepositoryLayout layout) {
        this.layout = layout;
    }
}
