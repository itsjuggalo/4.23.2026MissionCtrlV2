package com.google.firebase.firestore.proto;

import com.google.protobuf.AbstractC1062i;
import com.google.protobuf.AbstractC1063j;
import com.google.protobuf.AbstractC1077y;
import com.google.protobuf.C1070q;
import com.google.protobuf.g0;
import com.google.protobuf.u0;
import java.io.InputStream;
import java.nio.ByteBuffer;
import p2.C1695A;

/* JADX INFO: loaded from: classes.dex */
public final class Target extends AbstractC1077y implements TargetOrBuilder {
    private static final Target DEFAULT_INSTANCE;
    public static final int DOCUMENTS_FIELD_NUMBER = 6;
    public static final int LAST_LIMBO_FREE_SNAPSHOT_VERSION_FIELD_NUMBER = 7;
    public static final int LAST_LISTEN_SEQUENCE_NUMBER_FIELD_NUMBER = 4;
    private static volatile g0 PARSER = null;
    public static final int QUERY_FIELD_NUMBER = 5;
    public static final int RESUME_TOKEN_FIELD_NUMBER = 3;
    public static final int SNAPSHOT_VERSION_FIELD_NUMBER = 2;
    public static final int TARGET_ID_FIELD_NUMBER = 1;
    private int bitField0_;
    private u0 lastLimboFreeSnapshotVersion_;
    private long lastListenSequenceNumber_;
    private u0 snapshotVersion_;
    private int targetId_;
    private Object targetType_;
    private int targetTypeCase_ = 0;
    private AbstractC1062i resumeToken_ = AbstractC1062i.f11025b;

    /* JADX INFO: renamed from: com.google.firebase.firestore.proto.Target$1, reason: invalid class name */
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

    public static final class Builder extends AbstractC1077y.a implements TargetOrBuilder {
        public /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        public Builder clearDocuments() {
            copyOnWrite();
            ((Target) this.instance).clearDocuments();
            return this;
        }

        public Builder clearLastLimboFreeSnapshotVersion() {
            copyOnWrite();
            ((Target) this.instance).clearLastLimboFreeSnapshotVersion();
            return this;
        }

        public Builder clearLastListenSequenceNumber() {
            copyOnWrite();
            ((Target) this.instance).clearLastListenSequenceNumber();
            return this;
        }

        public Builder clearQuery() {
            copyOnWrite();
            ((Target) this.instance).clearQuery();
            return this;
        }

        public Builder clearResumeToken() {
            copyOnWrite();
            ((Target) this.instance).clearResumeToken();
            return this;
        }

        public Builder clearSnapshotVersion() {
            copyOnWrite();
            ((Target) this.instance).clearSnapshotVersion();
            return this;
        }

        public Builder clearTargetId() {
            copyOnWrite();
            ((Target) this.instance).clearTargetId();
            return this;
        }

        public Builder clearTargetType() {
            copyOnWrite();
            ((Target) this.instance).clearTargetType();
            return this;
        }

        @Override // com.google.firebase.firestore.proto.TargetOrBuilder
        public C1695A.c getDocuments() {
            return ((Target) this.instance).getDocuments();
        }

        @Override // com.google.firebase.firestore.proto.TargetOrBuilder
        public u0 getLastLimboFreeSnapshotVersion() {
            return ((Target) this.instance).getLastLimboFreeSnapshotVersion();
        }

        @Override // com.google.firebase.firestore.proto.TargetOrBuilder
        public long getLastListenSequenceNumber() {
            return ((Target) this.instance).getLastListenSequenceNumber();
        }

        @Override // com.google.firebase.firestore.proto.TargetOrBuilder
        public C1695A.d getQuery() {
            return ((Target) this.instance).getQuery();
        }

        @Override // com.google.firebase.firestore.proto.TargetOrBuilder
        public AbstractC1062i getResumeToken() {
            return ((Target) this.instance).getResumeToken();
        }

        @Override // com.google.firebase.firestore.proto.TargetOrBuilder
        public u0 getSnapshotVersion() {
            return ((Target) this.instance).getSnapshotVersion();
        }

        @Override // com.google.firebase.firestore.proto.TargetOrBuilder
        public int getTargetId() {
            return ((Target) this.instance).getTargetId();
        }

        @Override // com.google.firebase.firestore.proto.TargetOrBuilder
        public TargetTypeCase getTargetTypeCase() {
            return ((Target) this.instance).getTargetTypeCase();
        }

        @Override // com.google.firebase.firestore.proto.TargetOrBuilder
        public boolean hasDocuments() {
            return ((Target) this.instance).hasDocuments();
        }

        @Override // com.google.firebase.firestore.proto.TargetOrBuilder
        public boolean hasLastLimboFreeSnapshotVersion() {
            return ((Target) this.instance).hasLastLimboFreeSnapshotVersion();
        }

        @Override // com.google.firebase.firestore.proto.TargetOrBuilder
        public boolean hasQuery() {
            return ((Target) this.instance).hasQuery();
        }

        @Override // com.google.firebase.firestore.proto.TargetOrBuilder
        public boolean hasSnapshotVersion() {
            return ((Target) this.instance).hasSnapshotVersion();
        }

        public Builder mergeDocuments(C1695A.c cVar) {
            copyOnWrite();
            ((Target) this.instance).mergeDocuments(cVar);
            return this;
        }

        public Builder mergeLastLimboFreeSnapshotVersion(u0 u0Var) {
            copyOnWrite();
            ((Target) this.instance).mergeLastLimboFreeSnapshotVersion(u0Var);
            return this;
        }

        public Builder mergeQuery(C1695A.d dVar) {
            copyOnWrite();
            ((Target) this.instance).mergeQuery(dVar);
            return this;
        }

        public Builder mergeSnapshotVersion(u0 u0Var) {
            copyOnWrite();
            ((Target) this.instance).mergeSnapshotVersion(u0Var);
            return this;
        }

        public Builder setDocuments(C1695A.c cVar) {
            copyOnWrite();
            ((Target) this.instance).setDocuments(cVar);
            return this;
        }

        public Builder setLastLimboFreeSnapshotVersion(u0 u0Var) {
            copyOnWrite();
            ((Target) this.instance).setLastLimboFreeSnapshotVersion(u0Var);
            return this;
        }

        public Builder setLastListenSequenceNumber(long j4) {
            copyOnWrite();
            ((Target) this.instance).setLastListenSequenceNumber(j4);
            return this;
        }

        public Builder setQuery(C1695A.d dVar) {
            copyOnWrite();
            ((Target) this.instance).setQuery(dVar);
            return this;
        }

        public Builder setResumeToken(AbstractC1062i abstractC1062i) {
            copyOnWrite();
            ((Target) this.instance).setResumeToken(abstractC1062i);
            return this;
        }

        public Builder setSnapshotVersion(u0 u0Var) {
            copyOnWrite();
            ((Target) this.instance).setSnapshotVersion(u0Var);
            return this;
        }

        public Builder setTargetId(int i4) {
            copyOnWrite();
            ((Target) this.instance).setTargetId(i4);
            return this;
        }

        private Builder() {
            super(Target.DEFAULT_INSTANCE);
        }

        public Builder setDocuments(C1695A.c.a aVar) {
            copyOnWrite();
            ((Target) this.instance).setDocuments((C1695A.c) aVar.build());
            return this;
        }

        public Builder setLastLimboFreeSnapshotVersion(u0.b bVar) {
            copyOnWrite();
            ((Target) this.instance).setLastLimboFreeSnapshotVersion((u0) bVar.build());
            return this;
        }

        public Builder setQuery(C1695A.d.a aVar) {
            copyOnWrite();
            ((Target) this.instance).setQuery((C1695A.d) aVar.build());
            return this;
        }

        public Builder setSnapshotVersion(u0.b bVar) {
            copyOnWrite();
            ((Target) this.instance).setSnapshotVersion((u0) bVar.build());
            return this;
        }
    }

    public enum TargetTypeCase {
        QUERY(5),
        DOCUMENTS(6),
        TARGETTYPE_NOT_SET(0);

        private final int value;

        TargetTypeCase(int i4) {
            this.value = i4;
        }

        public static TargetTypeCase forNumber(int i4) {
            if (i4 == 0) {
                return TARGETTYPE_NOT_SET;
            }
            if (i4 == 5) {
                return QUERY;
            }
            if (i4 != 6) {
                return null;
            }
            return DOCUMENTS;
        }

        public int getNumber() {
            return this.value;
        }

        @Deprecated
        public static TargetTypeCase valueOf(int i4) {
            return forNumber(i4);
        }
    }

    static {
        Target target = new Target();
        DEFAULT_INSTANCE = target;
        AbstractC1077y.registerDefaultInstance(Target.class, target);
    }

    private Target() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearDocuments() {
        if (this.targetTypeCase_ == 6) {
            this.targetTypeCase_ = 0;
            this.targetType_ = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearLastLimboFreeSnapshotVersion() {
        this.lastLimboFreeSnapshotVersion_ = null;
        this.bitField0_ &= -3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearLastListenSequenceNumber() {
        this.lastListenSequenceNumber_ = 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearQuery() {
        if (this.targetTypeCase_ == 5) {
            this.targetTypeCase_ = 0;
            this.targetType_ = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearResumeToken() {
        this.resumeToken_ = getDefaultInstance().getResumeToken();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearSnapshotVersion() {
        this.snapshotVersion_ = null;
        this.bitField0_ &= -2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearTargetId() {
        this.targetId_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearTargetType() {
        this.targetTypeCase_ = 0;
        this.targetType_ = null;
    }

    public static Target getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeDocuments(C1695A.c cVar) {
        cVar.getClass();
        if (this.targetTypeCase_ != 6 || this.targetType_ == C1695A.c.n()) {
            this.targetType_ = cVar;
        } else {
            this.targetType_ = ((C1695A.c.a) C1695A.c.r((C1695A.c) this.targetType_).mergeFrom((AbstractC1077y) cVar)).buildPartial();
        }
        this.targetTypeCase_ = 6;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeLastLimboFreeSnapshotVersion(u0 u0Var) {
        u0Var.getClass();
        u0 u0Var2 = this.lastLimboFreeSnapshotVersion_;
        if (u0Var2 == null || u0Var2 == u0.m()) {
            this.lastLimboFreeSnapshotVersion_ = u0Var;
        } else {
            this.lastLimboFreeSnapshotVersion_ = (u0) ((u0.b) u0.q(this.lastLimboFreeSnapshotVersion_).mergeFrom((AbstractC1077y) u0Var)).buildPartial();
        }
        this.bitField0_ |= 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeQuery(C1695A.d dVar) {
        dVar.getClass();
        if (this.targetTypeCase_ != 5 || this.targetType_ == C1695A.d.m()) {
            this.targetType_ = dVar;
        } else {
            this.targetType_ = ((C1695A.d.a) C1695A.d.q((C1695A.d) this.targetType_).mergeFrom((AbstractC1077y) dVar)).buildPartial();
        }
        this.targetTypeCase_ = 5;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeSnapshotVersion(u0 u0Var) {
        u0Var.getClass();
        u0 u0Var2 = this.snapshotVersion_;
        if (u0Var2 == null || u0Var2 == u0.m()) {
            this.snapshotVersion_ = u0Var;
        } else {
            this.snapshotVersion_ = (u0) ((u0.b) u0.q(this.snapshotVersion_).mergeFrom((AbstractC1077y) u0Var)).buildPartial();
        }
        this.bitField0_ |= 1;
    }

    public static Builder newBuilder() {
        return (Builder) DEFAULT_INSTANCE.createBuilder();
    }

    public static Target parseDelimitedFrom(InputStream inputStream) {
        return (Target) AbstractC1077y.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Target parseFrom(ByteBuffer byteBuffer) {
        return (Target) AbstractC1077y.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static g0 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDocuments(C1695A.c cVar) {
        cVar.getClass();
        this.targetType_ = cVar;
        this.targetTypeCase_ = 6;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setLastLimboFreeSnapshotVersion(u0 u0Var) {
        u0Var.getClass();
        this.lastLimboFreeSnapshotVersion_ = u0Var;
        this.bitField0_ |= 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setLastListenSequenceNumber(long j4) {
        this.lastListenSequenceNumber_ = j4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setQuery(C1695A.d dVar) {
        dVar.getClass();
        this.targetType_ = dVar;
        this.targetTypeCase_ = 5;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setResumeToken(AbstractC1062i abstractC1062i) {
        abstractC1062i.getClass();
        this.resumeToken_ = abstractC1062i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSnapshotVersion(u0 u0Var) {
        u0Var.getClass();
        this.snapshotVersion_ = u0Var;
        this.bitField0_ |= 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTargetId(int i4) {
        this.targetId_ = i4;
    }

    @Override // com.google.protobuf.AbstractC1077y
    public final Object dynamicMethod(AbstractC1077y.e eVar, Object obj, Object obj2) {
        g0 bVar;
        AnonymousClass1 anonymousClass1 = null;
        switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[eVar.ordinal()]) {
            case 1:
                return new Target();
            case 2:
                return new Builder(anonymousClass1);
            case 3:
                return AbstractC1077y.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0007\u0001\u0001\u0001\u0007\u0007\u0000\u0000\u0000\u0001\u0004\u0002ဉ\u0000\u0003\n\u0004\u0002\u0005<\u0000\u0006<\u0000\u0007ဉ\u0001", new Object[]{"targetType_", "targetTypeCase_", "bitField0_", "targetId_", "snapshotVersion_", "resumeToken_", "lastListenSequenceNumber_", C1695A.d.class, C1695A.c.class, "lastLimboFreeSnapshotVersion_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                g0 g0Var = PARSER;
                if (g0Var != null) {
                    return g0Var;
                }
                synchronized (Target.class) {
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

    @Override // com.google.firebase.firestore.proto.TargetOrBuilder
    public C1695A.c getDocuments() {
        return this.targetTypeCase_ == 6 ? (C1695A.c) this.targetType_ : C1695A.c.n();
    }

    @Override // com.google.firebase.firestore.proto.TargetOrBuilder
    public u0 getLastLimboFreeSnapshotVersion() {
        u0 u0Var = this.lastLimboFreeSnapshotVersion_;
        return u0Var == null ? u0.m() : u0Var;
    }

    @Override // com.google.firebase.firestore.proto.TargetOrBuilder
    public long getLastListenSequenceNumber() {
        return this.lastListenSequenceNumber_;
    }

    @Override // com.google.firebase.firestore.proto.TargetOrBuilder
    public C1695A.d getQuery() {
        return this.targetTypeCase_ == 5 ? (C1695A.d) this.targetType_ : C1695A.d.m();
    }

    @Override // com.google.firebase.firestore.proto.TargetOrBuilder
    public AbstractC1062i getResumeToken() {
        return this.resumeToken_;
    }

    @Override // com.google.firebase.firestore.proto.TargetOrBuilder
    public u0 getSnapshotVersion() {
        u0 u0Var = this.snapshotVersion_;
        return u0Var == null ? u0.m() : u0Var;
    }

    @Override // com.google.firebase.firestore.proto.TargetOrBuilder
    public int getTargetId() {
        return this.targetId_;
    }

    @Override // com.google.firebase.firestore.proto.TargetOrBuilder
    public TargetTypeCase getTargetTypeCase() {
        return TargetTypeCase.forNumber(this.targetTypeCase_);
    }

    @Override // com.google.firebase.firestore.proto.TargetOrBuilder
    public boolean hasDocuments() {
        return this.targetTypeCase_ == 6;
    }

    @Override // com.google.firebase.firestore.proto.TargetOrBuilder
    public boolean hasLastLimboFreeSnapshotVersion() {
        return (this.bitField0_ & 2) != 0;
    }

    @Override // com.google.firebase.firestore.proto.TargetOrBuilder
    public boolean hasQuery() {
        return this.targetTypeCase_ == 5;
    }

    @Override // com.google.firebase.firestore.proto.TargetOrBuilder
    public boolean hasSnapshotVersion() {
        return (this.bitField0_ & 1) != 0;
    }

    public static Builder newBuilder(Target target) {
        return (Builder) DEFAULT_INSTANCE.createBuilder(target);
    }

    public static Target parseDelimitedFrom(InputStream inputStream, C1070q c1070q) {
        return (Target) AbstractC1077y.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c1070q);
    }

    public static Target parseFrom(ByteBuffer byteBuffer, C1070q c1070q) {
        return (Target) AbstractC1077y.parseFrom(DEFAULT_INSTANCE, byteBuffer, c1070q);
    }

    public static Target parseFrom(AbstractC1062i abstractC1062i) {
        return (Target) AbstractC1077y.parseFrom(DEFAULT_INSTANCE, abstractC1062i);
    }

    public static Target parseFrom(AbstractC1062i abstractC1062i, C1070q c1070q) {
        return (Target) AbstractC1077y.parseFrom(DEFAULT_INSTANCE, abstractC1062i, c1070q);
    }

    public static Target parseFrom(byte[] bArr) {
        return (Target) AbstractC1077y.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static Target parseFrom(byte[] bArr, C1070q c1070q) {
        return (Target) AbstractC1077y.parseFrom(DEFAULT_INSTANCE, bArr, c1070q);
    }

    public static Target parseFrom(InputStream inputStream) {
        return (Target) AbstractC1077y.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Target parseFrom(InputStream inputStream, C1070q c1070q) {
        return (Target) AbstractC1077y.parseFrom(DEFAULT_INSTANCE, inputStream, c1070q);
    }

    public static Target parseFrom(AbstractC1063j abstractC1063j) {
        return (Target) AbstractC1077y.parseFrom(DEFAULT_INSTANCE, abstractC1063j);
    }

    public static Target parseFrom(AbstractC1063j abstractC1063j, C1070q c1070q) {
        return (Target) AbstractC1077y.parseFrom(DEFAULT_INSTANCE, abstractC1063j, c1070q);
    }
}
