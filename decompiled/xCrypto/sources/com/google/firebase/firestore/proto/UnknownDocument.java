package com.google.firebase.firestore.proto;

import com.google.protobuf.AbstractC1050a;
import com.google.protobuf.AbstractC1062i;
import com.google.protobuf.AbstractC1063j;
import com.google.protobuf.AbstractC1077y;
import com.google.protobuf.C1070q;
import com.google.protobuf.g0;
import com.google.protobuf.u0;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes.dex */
public final class UnknownDocument extends AbstractC1077y implements UnknownDocumentOrBuilder {
    private static final UnknownDocument DEFAULT_INSTANCE;
    public static final int NAME_FIELD_NUMBER = 1;
    private static volatile g0 PARSER = null;
    public static final int VERSION_FIELD_NUMBER = 2;
    private int bitField0_;
    private String name_ = "";
    private u0 version_;

    /* JADX INFO: renamed from: com.google.firebase.firestore.proto.UnknownDocument$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke;

        static {
            int[] iArr = new int[AbstractC1077y.e.values().length];
            $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke = iArr;
            try {
                iArr[AbstractC1077y.e.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[AbstractC1077y.e.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[AbstractC1077y.e.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[AbstractC1077y.e.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[AbstractC1077y.e.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[AbstractC1077y.e.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[AbstractC1077y.e.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    public static final class Builder extends AbstractC1077y.a implements UnknownDocumentOrBuilder {
        public /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        public Builder clearName() {
            copyOnWrite();
            ((UnknownDocument) this.instance).clearName();
            return this;
        }

        public Builder clearVersion() {
            copyOnWrite();
            ((UnknownDocument) this.instance).clearVersion();
            return this;
        }

        @Override // com.google.firebase.firestore.proto.UnknownDocumentOrBuilder
        public String getName() {
            return ((UnknownDocument) this.instance).getName();
        }

        @Override // com.google.firebase.firestore.proto.UnknownDocumentOrBuilder
        public AbstractC1062i getNameBytes() {
            return ((UnknownDocument) this.instance).getNameBytes();
        }

        @Override // com.google.firebase.firestore.proto.UnknownDocumentOrBuilder
        public u0 getVersion() {
            return ((UnknownDocument) this.instance).getVersion();
        }

        @Override // com.google.firebase.firestore.proto.UnknownDocumentOrBuilder
        public boolean hasVersion() {
            return ((UnknownDocument) this.instance).hasVersion();
        }

        public Builder mergeVersion(u0 u0Var) {
            copyOnWrite();
            ((UnknownDocument) this.instance).mergeVersion(u0Var);
            return this;
        }

        public Builder setName(String str) {
            copyOnWrite();
            ((UnknownDocument) this.instance).setName(str);
            return this;
        }

        public Builder setNameBytes(AbstractC1062i abstractC1062i) {
            copyOnWrite();
            ((UnknownDocument) this.instance).setNameBytes(abstractC1062i);
            return this;
        }

        public Builder setVersion(u0 u0Var) {
            copyOnWrite();
            ((UnknownDocument) this.instance).setVersion(u0Var);
            return this;
        }

        private Builder() {
            super(UnknownDocument.DEFAULT_INSTANCE);
        }

        public Builder setVersion(u0.b bVar) {
            copyOnWrite();
            ((UnknownDocument) this.instance).setVersion((u0) bVar.build());
            return this;
        }
    }

    static {
        UnknownDocument unknownDocument = new UnknownDocument();
        DEFAULT_INSTANCE = unknownDocument;
        AbstractC1077y.registerDefaultInstance(UnknownDocument.class, unknownDocument);
    }

    private UnknownDocument() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearName() {
        this.name_ = getDefaultInstance().getName();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearVersion() {
        this.version_ = null;
        this.bitField0_ &= -2;
    }

    public static UnknownDocument getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeVersion(u0 u0Var) {
        u0Var.getClass();
        u0 u0Var2 = this.version_;
        if (u0Var2 == null || u0Var2 == u0.m()) {
            this.version_ = u0Var;
        } else {
            this.version_ = (u0) ((u0.b) u0.q(this.version_).mergeFrom((AbstractC1077y) u0Var)).buildPartial();
        }
        this.bitField0_ |= 1;
    }

    public static Builder newBuilder() {
        return (Builder) DEFAULT_INSTANCE.createBuilder();
    }

    public static UnknownDocument parseDelimitedFrom(InputStream inputStream) {
        return (UnknownDocument) AbstractC1077y.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static UnknownDocument parseFrom(ByteBuffer byteBuffer) {
        return (UnknownDocument) AbstractC1077y.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static g0 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setName(String str) {
        str.getClass();
        this.name_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setNameBytes(AbstractC1062i abstractC1062i) {
        AbstractC1050a.checkByteStringIsUtf8(abstractC1062i);
        this.name_ = abstractC1062i.K();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setVersion(u0 u0Var) {
        u0Var.getClass();
        this.version_ = u0Var;
        this.bitField0_ |= 1;
    }

    @Override // com.google.protobuf.AbstractC1077y
    public final Object dynamicMethod(AbstractC1077y.e eVar, Object obj, Object obj2) {
        g0 bVar;
        AnonymousClass1 anonymousClass1 = null;
        switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[eVar.ordinal()]) {
            case 1:
                return new UnknownDocument();
            case 2:
                return new Builder(anonymousClass1);
            case 3:
                return AbstractC1077y.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001Ȉ\u0002ဉ\u0000", new Object[]{"bitField0_", "name_", "version_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                g0 g0Var = PARSER;
                if (g0Var != null) {
                    return g0Var;
                }
                synchronized (UnknownDocument.class) {
                    try {
                        bVar = PARSER;
                        if (bVar == null) {
                            bVar = new AbstractC1077y.b(DEFAULT_INSTANCE);
                            PARSER = bVar;
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                    break;
                }
                return bVar;
            case 6:
                return (byte) 1;
            case 7:
                return null;
            default:
                throw new UnsupportedOperationException();
        }
    }

    @Override // com.google.firebase.firestore.proto.UnknownDocumentOrBuilder
    public String getName() {
        return this.name_;
    }

    @Override // com.google.firebase.firestore.proto.UnknownDocumentOrBuilder
    public AbstractC1062i getNameBytes() {
        return AbstractC1062i.r(this.name_);
    }

    @Override // com.google.firebase.firestore.proto.UnknownDocumentOrBuilder
    public u0 getVersion() {
        u0 u0Var = this.version_;
        return u0Var == null ? u0.m() : u0Var;
    }

    @Override // com.google.firebase.firestore.proto.UnknownDocumentOrBuilder
    public boolean hasVersion() {
        return (this.bitField0_ & 1) != 0;
    }

    public static Builder newBuilder(UnknownDocument unknownDocument) {
        return (Builder) DEFAULT_INSTANCE.createBuilder(unknownDocument);
    }

    public static UnknownDocument parseDelimitedFrom(InputStream inputStream, C1070q c1070q) {
        return (UnknownDocument) AbstractC1077y.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c1070q);
    }

    public static UnknownDocument parseFrom(ByteBuffer byteBuffer, C1070q c1070q) {
        return (UnknownDocument) AbstractC1077y.parseFrom(DEFAULT_INSTANCE, byteBuffer, c1070q);
    }

    public static UnknownDocument parseFrom(AbstractC1062i abstractC1062i) {
        return (UnknownDocument) AbstractC1077y.parseFrom(DEFAULT_INSTANCE, abstractC1062i);
    }

    public static UnknownDocument parseFrom(AbstractC1062i abstractC1062i, C1070q c1070q) {
        return (UnknownDocument) AbstractC1077y.parseFrom(DEFAULT_INSTANCE, abstractC1062i, c1070q);
    }

    public static UnknownDocument parseFrom(byte[] bArr) {
        return (UnknownDocument) AbstractC1077y.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static UnknownDocument parseFrom(byte[] bArr, C1070q c1070q) {
        return (UnknownDocument) AbstractC1077y.parseFrom(DEFAULT_INSTANCE, bArr, c1070q);
    }

    public static UnknownDocument parseFrom(InputStream inputStream) {
        return (UnknownDocument) AbstractC1077y.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static UnknownDocument parseFrom(InputStream inputStream, C1070q c1070q) {
        return (UnknownDocument) AbstractC1077y.parseFrom(DEFAULT_INSTANCE, inputStream, c1070q);
    }

    public static UnknownDocument parseFrom(AbstractC1063j abstractC1063j) {
        return (UnknownDocument) AbstractC1077y.parseFrom(DEFAULT_INSTANCE, abstractC1063j);
    }

    public static UnknownDocument parseFrom(AbstractC1063j abstractC1063j, C1070q c1070q) {
        return (UnknownDocument) AbstractC1077y.parseFrom(DEFAULT_INSTANCE, abstractC1063j, c1070q);
    }
}
