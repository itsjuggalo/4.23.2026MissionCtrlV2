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
public final class NoDocument extends AbstractC1077y implements NoDocumentOrBuilder {
    private static final NoDocument DEFAULT_INSTANCE;
    public static final int NAME_FIELD_NUMBER = 1;
    private static volatile g0 PARSER = null;
    public static final int READ_TIME_FIELD_NUMBER = 2;
    private int bitField0_;
    private String name_ = "";
    private u0 readTime_;

    /* JADX INFO: renamed from: com.google.firebase.firestore.proto.NoDocument$1, reason: invalid class name */
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

    public static final class Builder extends AbstractC1077y.a implements NoDocumentOrBuilder {
        public /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        public Builder clearName() {
            copyOnWrite();
            ((NoDocument) this.instance).clearName();
            return this;
        }

        public Builder clearReadTime() {
            copyOnWrite();
            ((NoDocument) this.instance).clearReadTime();
            return this;
        }

        @Override // com.google.firebase.firestore.proto.NoDocumentOrBuilder
        public String getName() {
            return ((NoDocument) this.instance).getName();
        }

        @Override // com.google.firebase.firestore.proto.NoDocumentOrBuilder
        public AbstractC1062i getNameBytes() {
            return ((NoDocument) this.instance).getNameBytes();
        }

        @Override // com.google.firebase.firestore.proto.NoDocumentOrBuilder
        public u0 getReadTime() {
            return ((NoDocument) this.instance).getReadTime();
        }

        @Override // com.google.firebase.firestore.proto.NoDocumentOrBuilder
        public boolean hasReadTime() {
            return ((NoDocument) this.instance).hasReadTime();
        }

        public Builder mergeReadTime(u0 u0Var) {
            copyOnWrite();
            ((NoDocument) this.instance).mergeReadTime(u0Var);
            return this;
        }

        public Builder setName(String str) {
            copyOnWrite();
            ((NoDocument) this.instance).setName(str);
            return this;
        }

        public Builder setNameBytes(AbstractC1062i abstractC1062i) {
            copyOnWrite();
            ((NoDocument) this.instance).setNameBytes(abstractC1062i);
            return this;
        }

        public Builder setReadTime(u0 u0Var) {
            copyOnWrite();
            ((NoDocument) this.instance).setReadTime(u0Var);
            return this;
        }

        private Builder() {
            super(NoDocument.DEFAULT_INSTANCE);
        }

        public Builder setReadTime(u0.b bVar) {
            copyOnWrite();
            ((NoDocument) this.instance).setReadTime((u0) bVar.build());
            return this;
        }
    }

    static {
        NoDocument noDocument = new NoDocument();
        DEFAULT_INSTANCE = noDocument;
        AbstractC1077y.registerDefaultInstance(NoDocument.class, noDocument);
    }

    private NoDocument() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearName() {
        this.name_ = getDefaultInstance().getName();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearReadTime() {
        this.readTime_ = null;
        this.bitField0_ &= -2;
    }

    public static NoDocument getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeReadTime(u0 u0Var) {
        u0Var.getClass();
        u0 u0Var2 = this.readTime_;
        if (u0Var2 == null || u0Var2 == u0.m()) {
            this.readTime_ = u0Var;
        } else {
            this.readTime_ = (u0) ((u0.b) u0.q(this.readTime_).mergeFrom((AbstractC1077y) u0Var)).buildPartial();
        }
        this.bitField0_ |= 1;
    }

    public static Builder newBuilder() {
        return (Builder) DEFAULT_INSTANCE.createBuilder();
    }

    public static NoDocument parseDelimitedFrom(InputStream inputStream) {
        return (NoDocument) AbstractC1077y.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static NoDocument parseFrom(ByteBuffer byteBuffer) {
        return (NoDocument) AbstractC1077y.parseFrom(DEFAULT_INSTANCE, byteBuffer);
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
    public void setReadTime(u0 u0Var) {
        u0Var.getClass();
        this.readTime_ = u0Var;
        this.bitField0_ |= 1;
    }

    @Override // com.google.protobuf.AbstractC1077y
    public final Object dynamicMethod(AbstractC1077y.e eVar, Object obj, Object obj2) {
        g0 bVar;
        AnonymousClass1 anonymousClass1 = null;
        switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[eVar.ordinal()]) {
            case 1:
                return new NoDocument();
            case 2:
                return new Builder(anonymousClass1);
            case 3:
                return AbstractC1077y.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001Ȉ\u0002ဉ\u0000", new Object[]{"bitField0_", "name_", "readTime_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                g0 g0Var = PARSER;
                if (g0Var != null) {
                    return g0Var;
                }
                synchronized (NoDocument.class) {
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

    @Override // com.google.firebase.firestore.proto.NoDocumentOrBuilder
    public String getName() {
        return this.name_;
    }

    @Override // com.google.firebase.firestore.proto.NoDocumentOrBuilder
    public AbstractC1062i getNameBytes() {
        return AbstractC1062i.r(this.name_);
    }

    @Override // com.google.firebase.firestore.proto.NoDocumentOrBuilder
    public u0 getReadTime() {
        u0 u0Var = this.readTime_;
        return u0Var == null ? u0.m() : u0Var;
    }

    @Override // com.google.firebase.firestore.proto.NoDocumentOrBuilder
    public boolean hasReadTime() {
        return (this.bitField0_ & 1) != 0;
    }

    public static Builder newBuilder(NoDocument noDocument) {
        return (Builder) DEFAULT_INSTANCE.createBuilder(noDocument);
    }

    public static NoDocument parseDelimitedFrom(InputStream inputStream, C1070q c1070q) {
        return (NoDocument) AbstractC1077y.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c1070q);
    }

    public static NoDocument parseFrom(ByteBuffer byteBuffer, C1070q c1070q) {
        return (NoDocument) AbstractC1077y.parseFrom(DEFAULT_INSTANCE, byteBuffer, c1070q);
    }

    public static NoDocument parseFrom(AbstractC1062i abstractC1062i) {
        return (NoDocument) AbstractC1077y.parseFrom(DEFAULT_INSTANCE, abstractC1062i);
    }

    public static NoDocument parseFrom(AbstractC1062i abstractC1062i, C1070q c1070q) {
        return (NoDocument) AbstractC1077y.parseFrom(DEFAULT_INSTANCE, abstractC1062i, c1070q);
    }

    public static NoDocument parseFrom(byte[] bArr) {
        return (NoDocument) AbstractC1077y.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static NoDocument parseFrom(byte[] bArr, C1070q c1070q) {
        return (NoDocument) AbstractC1077y.parseFrom(DEFAULT_INSTANCE, bArr, c1070q);
    }

    public static NoDocument parseFrom(InputStream inputStream) {
        return (NoDocument) AbstractC1077y.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static NoDocument parseFrom(InputStream inputStream, C1070q c1070q) {
        return (NoDocument) AbstractC1077y.parseFrom(DEFAULT_INSTANCE, inputStream, c1070q);
    }

    public static NoDocument parseFrom(AbstractC1063j abstractC1063j) {
        return (NoDocument) AbstractC1077y.parseFrom(DEFAULT_INSTANCE, abstractC1063j);
    }

    public static NoDocument parseFrom(AbstractC1063j abstractC1063j, C1070q c1070q) {
        return (NoDocument) AbstractC1077y.parseFrom(DEFAULT_INSTANCE, abstractC1063j, c1070q);
    }
}
