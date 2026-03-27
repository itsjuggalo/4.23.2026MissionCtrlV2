package com.google.protobuf;

import com.google.protobuf.AbstractC1062i;
import com.google.protobuf.W;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* JADX INFO: renamed from: com.google.protobuf.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC1050a implements W {
    protected int memoizedHashCode = 0;

    /* JADX INFO: renamed from: com.google.protobuf.a$a, reason: collision with other inner class name */
    public static abstract class AbstractC0158a implements W.a {
        @Deprecated
        public static <T> void addAll(Iterable<T> iterable, Collection<? super T> collection) {
            addAll((Iterable) iterable, (List) collection);
        }

        public static void b(Iterable iterable, List list) {
            if ((list instanceof ArrayList) && (iterable instanceof Collection)) {
                ((ArrayList) list).ensureCapacity(list.size() + ((Collection) iterable).size());
            }
            int size = list.size();
            for (Object obj : iterable) {
                if (obj == null) {
                    String str = "Element at index " + (list.size() - size) + " is null.";
                    for (int size2 = list.size() - 1; size2 >= size; size2--) {
                        list.remove(size2);
                    }
                    throw new NullPointerException(str);
                }
                list.add(obj);
            }
        }

        public static v0 newUninitializedMessageException(W w4) {
            return new v0(w4);
        }

        public final String c(String str) {
            return "Reading " + getClass().getName() + " from a " + str + " threw an IOException (should never happen).";
        }

        public abstract AbstractC0158a internalMergeFrom(AbstractC1050a abstractC1050a);

        public boolean mergeDelimitedFrom(InputStream inputStream, C1070q c1070q) throws IOException {
            int i4 = inputStream.read();
            if (i4 == -1) {
                return false;
            }
            mergeFrom((InputStream) new C0159a(inputStream, AbstractC1063j.z(i4, inputStream)), c1070q);
            return true;
        }

        @Override // com.google.protobuf.W.a
        public abstract AbstractC0158a mergeFrom(AbstractC1063j abstractC1063j, C1070q c1070q);

        public abstract AbstractC0158a mergeFrom(byte[] bArr, int i4, int i5);

        public abstract AbstractC0158a mergeFrom(byte[] bArr, int i4, int i5, C1070q c1070q);

        public static <T> void addAll(Iterable<T> iterable, List<? super T> list) {
            C.a(iterable);
            if (!(iterable instanceof K)) {
                if (iterable instanceof h0) {
                    list.addAll((Collection) iterable);
                    return;
                } else {
                    b(iterable, list);
                    return;
                }
            }
            List listG = ((K) iterable).g();
            K k4 = (K) list;
            int size = list.size();
            for (Object obj : listG) {
                if (obj == null) {
                    String str = "Element at index " + (k4.size() - size) + " is null.";
                    for (int size2 = k4.size() - 1; size2 >= size; size2--) {
                        k4.remove(size2);
                    }
                    throw new NullPointerException(str);
                }
                if (obj instanceof AbstractC1062i) {
                    k4.b((AbstractC1062i) obj);
                } else {
                    k4.add((String) obj);
                }
            }
        }

        /* JADX INFO: renamed from: com.google.protobuf.a$a$a, reason: collision with other inner class name */
        public static final class C0159a extends FilterInputStream {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public int f10997a;

            public C0159a(InputStream inputStream, int i4) {
                super(inputStream);
                this.f10997a = i4;
            }

            @Override // java.io.FilterInputStream, java.io.InputStream
            public int available() {
                return Math.min(super.available(), this.f10997a);
            }

            @Override // java.io.FilterInputStream, java.io.InputStream
            public int read() throws IOException {
                if (this.f10997a <= 0) {
                    return -1;
                }
                int i4 = super.read();
                if (i4 >= 0) {
                    this.f10997a--;
                }
                return i4;
            }

            @Override // java.io.FilterInputStream, java.io.InputStream
            public long skip(long j4) {
                int iSkip = (int) super.skip(Math.min(j4, this.f10997a));
                if (iSkip >= 0) {
                    this.f10997a -= iSkip;
                }
                return iSkip;
            }

            @Override // java.io.FilterInputStream, java.io.InputStream
            public int read(byte[] bArr, int i4, int i5) throws IOException {
                int i6 = this.f10997a;
                if (i6 <= 0) {
                    return -1;
                }
                int i7 = super.read(bArr, i4, Math.min(i5, i6));
                if (i7 >= 0) {
                    this.f10997a -= i7;
                }
                return i7;
            }
        }

        public boolean mergeDelimitedFrom(InputStream inputStream) {
            return mergeDelimitedFrom(inputStream, C1070q.b());
        }

        public AbstractC0158a mergeFrom(AbstractC1063j abstractC1063j) {
            return mergeFrom(abstractC1063j, C1070q.b());
        }

        public AbstractC0158a mergeFrom(AbstractC1062i abstractC1062i) throws D {
            try {
                AbstractC1063j abstractC1063jA = abstractC1062i.A();
                mergeFrom(abstractC1063jA);
                abstractC1063jA.a(0);
                return this;
            } catch (D e4) {
                throw e4;
            } catch (IOException e5) {
                throw new RuntimeException(c("ByteString"), e5);
            }
        }

        public AbstractC0158a mergeFrom(AbstractC1062i abstractC1062i, C1070q c1070q) throws D {
            try {
                AbstractC1063j abstractC1063jA = abstractC1062i.A();
                mergeFrom(abstractC1063jA, c1070q);
                abstractC1063jA.a(0);
                return this;
            } catch (D e4) {
                throw e4;
            } catch (IOException e5) {
                throw new RuntimeException(c("ByteString"), e5);
            }
        }

        public AbstractC0158a mergeFrom(byte[] bArr) {
            return mergeFrom(bArr, 0, bArr.length);
        }

        public AbstractC0158a mergeFrom(byte[] bArr, C1070q c1070q) {
            return mergeFrom(bArr, 0, bArr.length, c1070q);
        }

        public AbstractC0158a mergeFrom(InputStream inputStream) {
            AbstractC1063j abstractC1063jG = AbstractC1063j.g(inputStream);
            mergeFrom(abstractC1063jG);
            abstractC1063jG.a(0);
            return this;
        }

        public AbstractC0158a mergeFrom(InputStream inputStream, C1070q c1070q) {
            AbstractC1063j abstractC1063jG = AbstractC1063j.g(inputStream);
            mergeFrom(abstractC1063jG, c1070q);
            abstractC1063jG.a(0);
            return this;
        }

        @Override // com.google.protobuf.W.a
        public AbstractC0158a mergeFrom(W w4) {
            if (getDefaultInstanceForType().getClass().isInstance(w4)) {
                return internalMergeFrom((AbstractC1050a) w4);
            }
            throw new IllegalArgumentException("mergeFrom(MessageLite) can only merge messages of the same type.");
        }
    }

    @Deprecated
    public static <T> void addAll(Iterable<T> iterable, Collection<? super T> collection) {
        AbstractC0158a.addAll((Iterable) iterable, (List) collection);
    }

    public static void checkByteStringIsUtf8(AbstractC1062i abstractC1062i) {
        if (!abstractC1062i.x()) {
            throw new IllegalArgumentException("Byte string is not UTF-8.");
        }
    }

    public final String b(String str) {
        return "Serializing " + getClass().getName() + " to a " + str + " threw an IOException (should never happen).";
    }

    public abstract int getSerializedSize(o0 o0Var);

    public v0 newUninitializedMessageException() {
        return new v0(this);
    }

    @Override // com.google.protobuf.W
    public byte[] toByteArray() {
        try {
            byte[] bArr = new byte[getSerializedSize()];
            AbstractC1065l abstractC1065lD0 = AbstractC1065l.d0(bArr);
            writeTo(abstractC1065lD0);
            abstractC1065lD0.d();
            return bArr;
        } catch (IOException e4) {
            throw new RuntimeException(b("byte array"), e4);
        }
    }

    public AbstractC1062i toByteString() {
        try {
            AbstractC1062i.h hVarZ = AbstractC1062i.z(getSerializedSize());
            writeTo(hVarZ.b());
            return hVarZ.a();
        } catch (IOException e4) {
            throw new RuntimeException(b("ByteString"), e4);
        }
    }

    public void writeDelimitedTo(OutputStream outputStream) {
        int serializedSize = getSerializedSize();
        AbstractC1065l abstractC1065lC0 = AbstractC1065l.c0(outputStream, AbstractC1065l.G(AbstractC1065l.U(serializedSize) + serializedSize));
        abstractC1065lC0.V0(serializedSize);
        writeTo(abstractC1065lC0);
        abstractC1065lC0.Z();
    }

    @Override // com.google.protobuf.W
    public void writeTo(OutputStream outputStream) {
        AbstractC1065l abstractC1065lC0 = AbstractC1065l.c0(outputStream, AbstractC1065l.G(getSerializedSize()));
        writeTo(abstractC1065lC0);
        abstractC1065lC0.Z();
    }

    public static <T> void addAll(Iterable<T> iterable, List<? super T> list) {
        AbstractC0158a.addAll((Iterable) iterable, (List) list);
    }
}
