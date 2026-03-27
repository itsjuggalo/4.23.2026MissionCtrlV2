package t5;

import t5.D;

/* JADX INFO: renamed from: t5.a0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public abstract class AbstractC2664a0 implements D.g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Throwable f23697a = a();

    public static Throwable a() {
        try {
            Class.forName("javax.naming.directory.InitialDirContext");
            Class.forName("com.sun.jndi.dns.DnsContextFactory");
            return null;
        } catch (ClassNotFoundException | Error | RuntimeException e7) {
            return e7;
        }
    }
}
