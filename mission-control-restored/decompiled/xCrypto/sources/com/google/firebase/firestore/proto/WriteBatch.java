package com.google.firebase.firestore.proto;

import com.google.protobuf.AbstractC1050a;
import com.google.protobuf.AbstractC1062i;
import com.google.protobuf.AbstractC1063j;
import com.google.protobuf.AbstractC1077y;
import com.google.protobuf.C;
import com.google.protobuf.C1070q;
import com.google.protobuf.g0;
import com.google.protobuf.u0;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.List;
import p2.C1699E;
import p2.InterfaceC1700F;

/* JADX INFO: loaded from: classes.dex */
public final class WriteBatch extends AbstractC1077y implements WriteBatchOrBuilder {
    public static final int BASE_WRITES_FIELD_NUMBER = 4;
    public static final int BATCH_ID_FIELD_NUMBER = 1;
    private static final WriteBatch DEFAULT_INSTANCE;
    public static final int LOCAL_WRITE_TIME_FIELD_NUMBER = 3;
    private static volatile g0 PARSER = null;
    public static final int WRITES_FIELD_NUMBER = 2;
    private int batchId_;
    private int bitField0_;
    private u0 localWriteTime_;
    private C.i writes_ = AbstractC1077y.emptyProtobufList();
    private C.i baseWrites_ = AbstractC1077y.emptyProtobufList();

    /* JADX INFO: renamed from: com.google.firebase.firestore.proto.WriteBatch$1, reason: invalid class name */
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

    public static final class Builder extends AbstractC1077y.a implements WriteBatchOrBuilder {
        public /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        public Builder addAllBaseWrites(Iterable<? extends C1699E> iterable) {
            copyOnWrite();
            ((WriteBatch) this.instance).addAllBaseWrites(iterable);
            return this;
        }

        public Builder addAllWrites(Iterable<? extends C1699E> iterable) {
            copyOnWrite();
            ((WriteBatch) this.instance).addAllWrites(iterable);
            return this;
        }

        public Builder addBaseWrites(C1699E c1699e) {
            copyOnWrite();
            ((WriteBatch) this.instance).addBaseWrites(c1699e);
            return this;
        }

        public Builder addWrites(C1699E c1699e) {
            copyOnWrite();
            ((WriteBatch) this.instance).addWrites(c1699e);
            return this;
        }

        public Builder clearBaseWrites() {
            copyOnWrite();
            ((WriteBatch) this.instance).clearBaseWrites();
            return this;
        }

        public Builder clearBatchId() {
            copyOnWrite();
            ((WriteBatch) this.instance).clearBatchId();
            return this;
        }

        public Builder clearLocalWriteTime() {
            copyOnWrite();
            ((WriteBatch) this.instance).clearLocalWriteTime();
            return this;
        }

        public Builder clearWrites() {
            copyOnWrite();
            ((WriteBatch) this.instance).clearWrites();
            return this;
        }

        @Override // com.google.firebase.firestore.proto.WriteBatchOrBuilder
        public C1699E getBaseWrites(int i4) {
            return ((WriteBatch) this.instance).getBaseWrites(i4);
        }

        @Override // com.google.firebase.firestore.proto.WriteBatchOrBuilder
        public int getBaseWritesCount() {
            return ((WriteBatch) this.instance).getBaseWritesCount();
        }

        @Override // com.google.firebase.firestore.proto.WriteBatchOrBuilder
        public List<C1699E> getBaseWritesList() {
            return Collections.unmodifiableList(((WriteBatch) this.instance).getBaseWritesList());
        }

        @Override // com.google.firebase.firestore.proto.WriteBatchOrBuilder
        public int getBatchId() {
            return ((WriteBatch) this.instance).getBatchId();
        }

        @Override // com.google.firebase.firestore.proto.WriteBatchOrBuilder
        public u0 getLocalWriteTime() {
            return ((WriteBatch) this.instance).getLocalWriteTime();
        }

        @Override // com.google.firebase.firestore.proto.WriteBatchOrBuilder
        public C1699E getWrites(int i4) {
            return ((WriteBatch) this.instance).getWrites(i4);
        }

        @Override // com.google.firebase.firestore.proto.WriteBatchOrBuilder
        public int getWritesCount() {
            return ((WriteBatch) this.instance).getWritesCount();
        }

        @Override // com.google.firebase.firestore.proto.WriteBatchOrBuilder
        public List<C1699E> getWritesList() {
            return Collections.unmodifiableList(((WriteBatch) this.instance).getWritesList());
        }

        @Override // com.google.firebase.firestore.proto.WriteBatchOrBuilder
        public boolean hasLocalWriteTime() {
            return ((WriteBatch) this.instance).hasLocalWriteTime();
        }

        public Builder mergeLocalWriteTime(u0 u0Var) {
            copyOnWrite();
            ((WriteBatch) this.instance).mergeLocalWriteTime(u0Var);
            return this;
        }

        public Builder removeBaseWrites(int i4) {
            copyOnWrite();
            ((WriteBatch) this.instance).removeBaseWrites(i4);
            return this;
        }

        public Builder removeWrites(int i4) {
            copyOnWrite();
            ((WriteBatch) this.instance).removeWrites(i4);
            return this;
        }

        public Builder setBaseWrites(int i4, C1699E c1699e) {
            copyOnWrite();
            ((WriteBatch) this.instance).setBaseWrites(i4, c1699e);
            return this;
        }

        public Builder setBatchId(int i4) {
            copyOnWrite();
            ((WriteBatch) this.instance).setBatchId(i4);
            return this;
        }

        public Builder setLocalWriteTime(u0 u0Var) {
            copyOnWrite();
            ((WriteBatch) this.instance).setLocalWriteTime(u0Var);
            return this;
        }

        public Builder setWrites(int i4, C1699E c1699e) {
            copyOnWrite();
            ((WriteBatch) this.instance).setWrites(i4, c1699e);
            return this;
        }

        private Builder() {
            super(WriteBatch.DEFAULT_INSTANCE);
        }

        public Builder addBaseWrites(int i4, C1699E c1699e) {
            copyOnWrite();
            ((WriteBatch) this.instance).addBaseWrites(i4, c1699e);
            return this;
        }

        public Builder addWrites(int i4, C1699E c1699e) {
            copyOnWrite();
            ((WriteBatch) this.instance).addWrites(i4, c1699e);
            return this;
        }

        public Builder setBaseWrites(int i4, C1699E.b bVar) {
            copyOnWrite();
            ((WriteBatch) this.instance).setBaseWrites(i4, (C1699E) bVar.build());
            return this;
        }

        public Builder setLocalWriteTime(u0.b bVar) {
            copyOnWrite();
            ((WriteBatch) this.instance).setLocalWriteTime((u0) bVar.build());
            return this;
        }

        public Builder setWrites(int i4, C1699E.b bVar) {
            copyOnWrite();
            ((WriteBatch) this.instance).setWrites(i4, (C1699E) bVar.build());
            return this;
        }

        public Builder addBaseWrites(C1699E.b bVar) {
            copyOnWrite();
            ((WriteBatch) this.instance).addBaseWrites((C1699E) bVar.build());
            return this;
        }

        public Builder addWrites(C1699E.b bVar) {
            copyOnWrite();
            ((WriteBatch) this.instance).addWrites((C1699E) bVar.build());
            return this;
        }

        public Builder addBaseWrites(int i4, C1699E.b bVar) {
            copyOnWrite();
            ((WriteBatch) this.instance).addBaseWrites(i4, (C1699E) bVar.build());
            return this;
        }

        public Builder addWrites(int i4, C1699E.b bVar) {
            copyOnWrite();
            ((WriteBatch) this.instance).addWrites(i4, (C1699E) bVar.build());
            return this;
        }
    }

    static {
        WriteBatch writeBatch = new WriteBatch();
        DEFAULT_INSTANCE = writeBatch;
        AbstractC1077y.registerDefaultInstance(WriteBatch.class, writeBatch);
    }

    private WriteBatch() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllBaseWrites(Iterable<? extends C1699E> iterable) {
        ensureBaseWritesIsMutable();
        AbstractC1050a.addAll((Iterable) iterable, (List) this.baseWrites_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllWrites(Iterable<? extends C1699E> iterable) {
        ensureWritesIsMutable();
        AbstractC1050a.addAll((Iterable) iterable, (List) this.writes_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addBaseWrites(C1699E c1699e) {
        c1699e.getClass();
        ensureBaseWritesIsMutable();
        this.baseWrites_.add(c1699e);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addWrites(C1699E c1699e) {
        c1699e.getClass();
        ensureWritesIsMutable();
        this.writes_.add(c1699e);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearBaseWrites() {
        this.baseWrites_ = AbstractC1077y.emptyProtobufList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearBatchId() {
        this.batchId_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearLocalWriteTime() {
        this.localWriteTime_ = null;
        this.bitField0_ &= -2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearWrites() {
        this.writes_ = AbstractC1077y.emptyProtobufList();
    }

    private void ensureBaseWritesIsMutable() {
        C.i iVar = this.baseWrites_;
        if (iVar.e()) {
            return;
        }
        this.baseWrites_ = AbstractC1077y.mutableCopy(iVar);
    }

    private void ensureWritesIsMutable() {
        C.i iVar = this.writes_;
        if (iVar.e()) {
            return;
        }
        this.writes_ = AbstractC1077y.mutableCopy(iVar);
    }

    public static WriteBatch getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeLocalWriteTime(u0 u0Var) {
        u0Var.getClass();
        u0 u0Var2 = this.localWriteTime_;
        if (u0Var2 == null || u0Var2 == u0.m()) {
            this.localWriteTime_ = u0Var;
        } else {
            this.localWriteTime_ = (u0) ((u0.b) u0.q(this.localWriteTime_).mergeFrom((AbstractC1077y) u0Var)).buildPartial();
        }
        this.bitField0_ |= 1;
    }

    public static Builder newBuilder() {
        return (Builder) DEFAULT_INSTANCE.createBuilder();
    }

    public static WriteBatch parseDelimitedFrom(InputStream inputStream) {
        return (WriteBatch) AbstractC1077y.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static WriteBatch parseFrom(ByteBuffer byteBuffer) {
        return (WriteBatch) AbstractC1077y.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static g0 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeBaseWrites(int i4) {
        ensureBaseWritesIsMutable();
        this.baseWrites_.remove(i4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeWrites(int i4) {
        ensureWritesIsMutable();
        this.writes_.remove(i4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setBaseWrites(int i4, C1699E c1699e) {
        c1699e.getClass();
        ensureBaseWritesIsMutable();
        this.baseWrites_.set(i4, c1699e);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setBatchId(int i4) {
        this.batchId_ = i4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setLocalWriteTime(u0 u0Var) {
        u0Var.getClass();
        this.localWriteTime_ = u0Var;
        this.bitField0_ |= 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setWrites(int i4, C1699E c1699e) {
        c1699e.getClass();
        ensureWritesIsMutable();
        this.writes_.set(i4, c1699e);
    }

    @Override // com.google.protobuf.AbstractC1077y
    public final Object dynamicMethod(AbstractC1077y.e eVar, Object obj, Object obj2) {
        g0 bVar;
        AnonymousClass1 anonymousClass1 = null;
        switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[eVar.ordinal()]) {
            case 1:
                return new WriteBatch();
            case 2:
                return new Builder(anonymousClass1);
            case 3:
                return AbstractC1077y.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0002\u0000\u0001\u0004\u0002\u001b\u0003ဉ\u0000\u0004\u001b", new Object[]{"bitField0_", "batchId_", "writes_", C1699E.class, "localWriteTime_", "baseWrites_", C1699E.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                g0 g0Var = PARSER;
                if (g0Var != null) {
                    return g0Var;
                }
                synchronized (WriteBatch.class) {
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

    @Override // com.google.firebase.firestore.proto.WriteBatchOrBuilder
    public C1699E getBaseWrites(int i4) {
        return (C1699E) this.baseWrites_.get(i4);
    }

    @Override // com.google.firebase.firestore.proto.WriteBatchOrBuilder
    public int getBaseWritesCount() {
        return this.baseWrites_.size();
    }

    @Override // com.google.firebase.firestore.proto.WriteBatchOrBuilder
    public List<C1699E> getBaseWritesList() {
        return this.baseWrites_;
    }

    public InterfaceC1700F getBaseWritesOrBuilder(int i4) {
        return (InterfaceC1700F) this.baseWrites_.get(i4);
    }

    public List<? extends InterfaceC1700F> getBaseWritesOrBuilderList() {
        return this.baseWrites_;
    }

    @Override // com.google.firebase.firestore.proto.WriteBatchOrBuilder
    public int getBatchId() {
        return this.batchId_;
    }

    @Override // com.google.firebase.firestore.proto.WriteBatchOrBuilder
    public u0 getLocalWriteTime() {
        u0 u0Var = this.localWriteTime_;
        return u0Var == null ? u0.m() : u0Var;
    }

    @Override // com.google.firebase.firestore.proto.WriteBatchOrBuilder
    public C1699E getWrites(int i4) {
        return (C1699E) this.writes_.get(i4);
    }

    @Override // com.google.firebase.firestore.proto.WriteBatchOrBuilder
    public int getWritesCount() {
        return this.writes_.size();
    }

    @Override // com.google.firebase.firestore.proto.WriteBatchOrBuilder
    public List<C1699E> getWritesList() {
        return this.writes_;
    }

    public InterfaceC1700F getWritesOrBuilder(int i4) {
        return (InterfaceC1700F) this.writes_.get(i4);
    }

    public List<? extends InterfaceC1700F> getWritesOrBuilderList() {
        return this.writes_;
    }

    @Override // com.google.firebase.firestore.proto.WriteBatchOrBuilder
    public boolean hasLocalWriteTime() {
        return (this.bitField0_ & 1) != 0;
    }

    public static Builder newBuilder(WriteBatch writeBatch) {
        return (Builder) DEFAULT_INSTANCE.createBuilder(writeBatch);
    }

    public static WriteBatch parseDelimitedFrom(InputStream inputStream, C1070q c1070q) {
        return (WriteBatch) AbstractC1077y.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c1070q);
    }

    public static WriteBatch parseFrom(ByteBuffer byteBuffer, C1070q c1070q) {
        return (WriteBatch) AbstractC1077y.parseFrom(DEFAULT_INSTANCE, byteBuffer, c1070q);
    }

    public static WriteBatch parseFrom(AbstractC1062i abstractC1062i) {
        return (WriteBatch) AbstractC1077y.parseFrom(DEFAULT_INSTANCE, abstractC1062i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addBaseWrites(int i4, C1699E c1699e) {
        c1699e.getClass();
        ensureBaseWritesIsMutable();
        this.baseWrites_.add(i4, c1699e);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addWrites(int i4, C1699E c1699e) {
        c1699e.getClass();
        ensureWritesIsMutable();
        this.writes_.add(i4, c1699e);
    }

    public static WriteBatch parseFrom(AbstractC1062i abstractC1062i, C1070q c1070q) {
        return (WriteBatch) AbstractC1077y.parseFrom(DEFAULT_INSTANCE, abstractC1062i, c1070q);
    }

    public static WriteBatch parseFrom(byte[] bArr) {
        return (WriteBatch) AbstractC1077y.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static WriteBatch parseFrom(byte[] bArr, C1070q c1070q) {
        return (WriteBatch) AbstractC1077y.parseFrom(DEFAULT_INSTANCE, bArr, c1070q);
    }

    public static WriteBatch parseFrom(InputStream inputStream) {
        return (WriteBatch) AbstractC1077y.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static WriteBatch parseFrom(InputStream inputStream, C1070q c1070q) {
        return (WriteBatch) AbstractC1077y.parseFrom(DEFAULT_INSTANCE, inputStream, c1070q);
    }

    public static WriteBatch parseFrom(AbstractC1063j abstractC1063j) {
        return (WriteBatch) AbstractC1077y.parseFrom(DEFAULT_INSTANCE, abstractC1063j);
    }

    public static WriteBatch parseFrom(AbstractC1063j abstractC1063j, C1070q c1070q) {
        return (WriteBatch) AbstractC1077y.parseFrom(DEFAULT_INSTANCE, abstractC1063j, c1070q);
    }
}
