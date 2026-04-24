package g2;

import java.security.KeyFactory;
import java.security.KeyPairGenerator;
import java.security.MessageDigest;
import java.security.Provider;
import java.security.Signature;
import javax.crypto.Cipher;
import javax.crypto.KeyAgreement;
import javax.crypto.Mac;

/* JADX INFO: renamed from: g2.e, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public interface InterfaceC1268e {

    /* JADX INFO: renamed from: g2.e$a */
    public static class a implements InterfaceC1268e {
        @Override // g2.InterfaceC1268e
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public Cipher a(String str, Provider provider) {
            return provider == null ? Cipher.getInstance(str) : Cipher.getInstance(str, provider);
        }
    }

    /* JADX INFO: renamed from: g2.e$b */
    public static class b implements InterfaceC1268e {
        @Override // g2.InterfaceC1268e
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public KeyAgreement a(String str, Provider provider) {
            return provider == null ? KeyAgreement.getInstance(str) : KeyAgreement.getInstance(str, provider);
        }
    }

    /* JADX INFO: renamed from: g2.e$c */
    public static class c implements InterfaceC1268e {
        @Override // g2.InterfaceC1268e
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public KeyFactory a(String str, Provider provider) {
            return provider == null ? KeyFactory.getInstance(str) : KeyFactory.getInstance(str, provider);
        }
    }

    /* JADX INFO: renamed from: g2.e$d */
    public static class d implements InterfaceC1268e {
        @Override // g2.InterfaceC1268e
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public KeyPairGenerator a(String str, Provider provider) {
            return provider == null ? KeyPairGenerator.getInstance(str) : KeyPairGenerator.getInstance(str, provider);
        }
    }

    /* JADX INFO: renamed from: g2.e$e, reason: collision with other inner class name */
    public static class C0199e implements InterfaceC1268e {
        @Override // g2.InterfaceC1268e
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public Mac a(String str, Provider provider) {
            return provider == null ? Mac.getInstance(str) : Mac.getInstance(str, provider);
        }
    }

    /* JADX INFO: renamed from: g2.e$f */
    public static class f implements InterfaceC1268e {
        @Override // g2.InterfaceC1268e
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public MessageDigest a(String str, Provider provider) {
            return provider == null ? MessageDigest.getInstance(str) : MessageDigest.getInstance(str, provider);
        }
    }

    /* JADX INFO: renamed from: g2.e$g */
    public static class g implements InterfaceC1268e {
        @Override // g2.InterfaceC1268e
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public Signature a(String str, Provider provider) {
            return provider == null ? Signature.getInstance(str) : Signature.getInstance(str, provider);
        }
    }

    Object a(String str, Provider provider);
}
