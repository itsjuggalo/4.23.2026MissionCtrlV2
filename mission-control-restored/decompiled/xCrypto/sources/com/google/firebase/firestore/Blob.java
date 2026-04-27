package com.google.firebase.firestore;

import com.google.firebase.firestore.util.Preconditions;
import com.google.firebase.firestore.util.Util;
import com.google.protobuf.AbstractC1062i;

/* JADX INFO: loaded from: classes.dex */
public class Blob implements Comparable<Blob> {
    private final AbstractC1062i bytes;

    private Blob(AbstractC1062i abstractC1062i) {
        this.bytes = abstractC1062i;
    }

    public static Blob fromByteString(AbstractC1062i abstractC1062i) {
        Preconditions.checkNotNull(abstractC1062i, "Provided ByteString must not be null.");
        return new Blob(abstractC1062i);
    }

    public static Blob fromBytes(byte[] bArr) {
        Preconditions.checkNotNull(bArr, "Provided bytes array must not be null.");
        return new Blob(AbstractC1062i.p(bArr));
    }

    public boolean equals(Object obj) {
        return (obj instanceof Blob) && this.bytes.equals(((Blob) obj).bytes);
    }

    public int hashCode() {
        return this.bytes.hashCode();
    }

    public AbstractC1062i toByteString() {
        return this.bytes;
    }

    public byte[] toBytes() {
        return this.bytes.G();
    }

    public String toString() {
        return "Blob { bytes=" + Util.toDebugString(this.bytes) + " }";
    }

    @Override // java.lang.Comparable
    public int compareTo(Blob blob) {
        return Util.compareByteStrings(this.bytes, blob.bytes);
    }
}
