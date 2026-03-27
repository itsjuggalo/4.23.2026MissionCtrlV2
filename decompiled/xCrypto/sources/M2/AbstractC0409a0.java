package M2;

import M2.D;

/* JADX INFO: renamed from: M2.a0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC0409a0 implements D.g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Throwable f2146a = a();

    public static Throwable a() {
        try {
            Class.forName("javax.naming.directory.InitialDirContext");
            Class.forName("com.sun.jndi.dns.DnsContextFactory");
            return null;
        } catch (ClassNotFoundException e4) {
            return e4;
        } catch (Error e5) {
            return e5;
        } catch (RuntimeException e6) {
            return e6;
        }
    }
}
