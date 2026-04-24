package a1;

import com.google.firebase.encoders.proto.ProtobufEncoder;

/* JADX INFO: loaded from: classes.dex */
public abstract class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ProtobufEncoder f6095a = ProtobufEncoder.builder().configureWith(C0776a.f6019a).build();

    public static byte[] a(Object obj) {
        return f6095a.encode(obj);
    }
}
