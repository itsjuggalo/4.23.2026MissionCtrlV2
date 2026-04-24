package h4;

import java.util.HashMap;

/* JADX INFO: renamed from: h4.n, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0635n extends RuntimeException {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f6627a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final HashMap f6628b;

    public C0635n(String str, String str2, HashMap map) {
        super(str2);
        this.f6627a = str;
        this.f6628b = map;
    }
}
