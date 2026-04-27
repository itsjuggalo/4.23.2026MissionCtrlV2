package com.google.gson;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: loaded from: classes.dex */
public abstract class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final q f16255a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final q f16256b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ q[] f16257c;

    public enum a extends q {
        public a(String str, int i8) {
            super(str, i8, null);
        }
    }

    static {
        a aVar = new a("DEFAULT", 0);
        f16255a = aVar;
        q qVar = new q("STRING", 1) { // from class: com.google.gson.q.b
            {
                a aVar2 = null;
            }
        };
        f16256b = qVar;
        f16257c = new q[]{aVar, qVar};
    }

    public q(String str, int i8) {
    }

    public static q valueOf(String str) {
        return (q) Enum.valueOf(q.class, str);
    }

    public static q[] values() {
        return (q[]) f16257c.clone();
    }

    public /* synthetic */ q(String str, int i8, a aVar) {
        this(str, i8);
    }
}
