package androidx.datastore.preferences.protobuf;

/* JADX INFO: loaded from: classes.dex */
public interface J extends K {

    public interface a extends K, Cloneable {
        J buildPartial();
    }

    void a(AbstractC0796i abstractC0796i);

    int getSerializedSize();

    a newBuilderForType();
}
