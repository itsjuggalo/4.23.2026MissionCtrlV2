package G4;

import G4.D;

/* JADX INFO: renamed from: G4.a0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public abstract class AbstractC0517a0 implements D.g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Throwable f2734a = a();

    public static Throwable a() {
        try {
            Class.forName("javax.naming.directory.InitialDirContext");
            Class.forName("com.sun.jndi.dns.DnsContextFactory");
            return null;
        } catch (ClassNotFoundException | Error | RuntimeException e8) {
            return e8;
        }
    }
}
