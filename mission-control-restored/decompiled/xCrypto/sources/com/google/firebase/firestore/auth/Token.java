package com.google.firebase.firestore.auth;

/* JADX INFO: loaded from: classes.dex */
public final class Token {
    private final User user;
    private final String value;

    public Token(String str, User user) {
        this.value = str;
        this.user = user;
    }

    public User getUser() {
        return this.user;
    }

    public String getValue() {
        return this.value;
    }
}
