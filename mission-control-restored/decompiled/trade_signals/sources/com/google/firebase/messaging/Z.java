package com.google.firebase.messaging;

import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public final class Z extends Exception {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f15670a;

    public Z(String str) {
        super(str);
        this.f15670a = a(str);
    }

    public final int a(String str) {
        if (str == null) {
            return 0;
        }
        String lowerCase = str.toLowerCase(Locale.US);
        lowerCase.hashCode();
        switch (lowerCase) {
        }
        return 0;
    }
}
