package com.google.firebase.firestore.local;

import com.google.firebase.Timestamp;
import com.google.firebase.firestore.bundle.BundledQuery;
import com.google.firebase.firestore.core.Query;
import com.google.firebase.firestore.model.Document;
import com.google.firebase.firestore.model.FieldIndex;
import com.google.firebase.firestore.model.FieldPath;
import com.google.firebase.firestore.model.MutableDocument;
import com.google.firebase.firestore.model.ObjectValue;
import com.google.firebase.firestore.model.SnapshotVersion;
import com.google.firebase.firestore.model.mutation.Mutation;
import com.google.firebase.firestore.model.mutation.MutationBatch;
import com.google.firebase.firestore.proto.MaybeDocument;
import com.google.firebase.firestore.proto.NoDocument;
import com.google.firebase.firestore.proto.Target;
import com.google.firebase.firestore.proto.UnknownDocument;
import com.google.firebase.firestore.proto.WriteBatch;
import com.google.firebase.firestore.remote.RemoteSerializer;
import com.google.firebase.firestore.util.Assert;
import com.google.protobuf.AbstractC1062i;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import n2.C1632a;
import o2.C1669a;
import p2.C1695A;
import p2.C1699E;
import p2.k;
import p2.p;

/* JADX INFO: loaded from: classes.dex */
public final class LocalSerializer {
    private final RemoteSerializer rpcSerializer;

    /* JADX INFO: renamed from: com.google.firebase.firestore.local.LocalSerializer$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$firebase$firestore$proto$MaybeDocument$DocumentTypeCase;
        static final /* synthetic */ int[] $SwitchMap$com$google$firebase$firestore$proto$Target$TargetTypeCase;

        static {
            int[] iArr = new int[Target.TargetTypeCase.values().length];
            $SwitchMap$com$google$firebase$firestore$proto$Target$TargetTypeCase = iArr;
            try {
                iArr[Target.TargetTypeCase.DOCUMENTS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$google$firebase$firestore$proto$Target$TargetTypeCase[Target.TargetTypeCase.QUERY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            int[] iArr2 = new int[MaybeDocument.DocumentTypeCase.values().length];
            $SwitchMap$com$google$firebase$firestore$proto$MaybeDocument$DocumentTypeCase = iArr2;
            try {
                iArr2[MaybeDocument.DocumentTypeCase.DOCUMENT.ordinal()] = 1;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$google$firebase$firestore$proto$MaybeDocument$DocumentTypeCase[MaybeDocument.DocumentTypeCase.NO_DOCUMENT.ordinal()] = 2;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$google$firebase$firestore$proto$MaybeDocument$DocumentTypeCase[MaybeDocument.DocumentTypeCase.UNKNOWN_DOCUMENT.ordinal()] = 3;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    public LocalSerializer(RemoteSerializer remoteSerializer) {
        this.rpcSerializer = remoteSerializer;
    }

    private MutableDocument decodeDocument(p2.k kVar, boolean z4) {
        MutableDocument mutableDocumentNewFoundDocument = MutableDocument.newFoundDocument(this.rpcSerializer.decodeKey(kVar.getName()), this.rpcSerializer.decodeVersion(kVar.q()), ObjectValue.fromMap(kVar.o()));
        return z4 ? mutableDocumentNewFoundDocument.setHasCommittedMutations() : mutableDocumentNewFoundDocument;
    }

    private MutableDocument decodeNoDocument(NoDocument noDocument, boolean z4) {
        MutableDocument mutableDocumentNewNoDocument = MutableDocument.newNoDocument(this.rpcSerializer.decodeKey(noDocument.getName()), this.rpcSerializer.decodeVersion(noDocument.getReadTime()));
        return z4 ? mutableDocumentNewNoDocument.setHasCommittedMutations() : mutableDocumentNewNoDocument;
    }

    private MutableDocument decodeUnknownDocument(UnknownDocument unknownDocument) {
        return MutableDocument.newUnknownDocument(this.rpcSerializer.decodeKey(unknownDocument.getName()), this.rpcSerializer.decodeVersion(unknownDocument.getVersion()));
    }

    private p2.k encodeDocument(Document document) {
        k.b bVarT = p2.k.t();
        bVarT.g(this.rpcSerializer.encodeKey(document.getKey()));
        bVarT.f(document.getData().getFieldsMap());
        bVarT.h(this.rpcSerializer.encodeTimestamp(document.getVersion().getTimestamp()));
        return (p2.k) bVarT.build();
    }

    private NoDocument encodeNoDocument(Document document) {
        NoDocument.Builder builderNewBuilder = NoDocument.newBuilder();
        builderNewBuilder.setName(this.rpcSerializer.encodeKey(document.getKey()));
        builderNewBuilder.setReadTime(this.rpcSerializer.encodeTimestamp(document.getVersion().getTimestamp()));
        return (NoDocument) builderNewBuilder.build();
    }

    private UnknownDocument encodeUnknownDocument(Document document) {
        UnknownDocument.Builder builderNewBuilder = UnknownDocument.newBuilder();
        builderNewBuilder.setName(this.rpcSerializer.encodeKey(document.getKey()));
        builderNewBuilder.setVersion(this.rpcSerializer.encodeTimestamp(document.getVersion().getTimestamp()));
        return (UnknownDocument) builderNewBuilder.build();
    }

    public BundledQuery decodeBundledQuery(C1669a c1669a) {
        return new BundledQuery(this.rpcSerializer.decodeQueryTarget(c1669a.o(), c1669a.p()), c1669a.n().equals(C1669a.c.FIRST) ? Query.LimitType.LIMIT_TO_FIRST : Query.LimitType.LIMIT_TO_LAST);
    }

    public List<FieldIndex.Segment> decodeFieldIndexSegments(C1632a c1632a) {
        ArrayList arrayList = new ArrayList();
        for (C1632a.c cVar : c1632a.o()) {
            arrayList.add(FieldIndex.Segment.create(FieldPath.fromServerFormat(cVar.n()), cVar.p().equals(C1632a.c.d.ARRAY_CONFIG) ? FieldIndex.Segment.Kind.CONTAINS : cVar.o().equals(C1632a.c.EnumC0214c.ASCENDING) ? FieldIndex.Segment.Kind.ASCENDING : FieldIndex.Segment.Kind.DESCENDING));
        }
        return arrayList;
    }

    public MutableDocument decodeMaybeDocument(MaybeDocument maybeDocument) {
        int i4 = AnonymousClass1.$SwitchMap$com$google$firebase$firestore$proto$MaybeDocument$DocumentTypeCase[maybeDocument.getDocumentTypeCase().ordinal()];
        if (i4 == 1) {
            return decodeDocument(maybeDocument.getDocument(), maybeDocument.getHasCommittedMutations());
        }
        if (i4 == 2) {
            return decodeNoDocument(maybeDocument.getNoDocument(), maybeDocument.getHasCommittedMutations());
        }
        if (i4 == 3) {
            return decodeUnknownDocument(maybeDocument.getUnknownDocument());
        }
        throw Assert.fail("Unknown MaybeDocument %s", maybeDocument);
    }

    public Mutation decodeMutation(C1699E c1699e) {
        return this.rpcSerializer.decodeMutation(c1699e);
    }

    public MutationBatch decodeMutationBatch(WriteBatch writeBatch) {
        int batchId = writeBatch.getBatchId();
        Timestamp timestampDecodeTimestamp = this.rpcSerializer.decodeTimestamp(writeBatch.getLocalWriteTime());
        int baseWritesCount = writeBatch.getBaseWritesCount();
        ArrayList arrayList = new ArrayList(baseWritesCount);
        for (int i4 = 0; i4 < baseWritesCount; i4++) {
            arrayList.add(this.rpcSerializer.decodeMutation(writeBatch.getBaseWrites(i4)));
        }
        ArrayList arrayList2 = new ArrayList(writeBatch.getWritesCount());
        int i5 = 0;
        while (i5 < writeBatch.getWritesCount()) {
            C1699E writes = writeBatch.getWrites(i5);
            int i6 = i5 + 1;
            if (i6 >= writeBatch.getWritesCount() || !writeBatch.getWrites(i6).B()) {
                arrayList2.add(this.rpcSerializer.decodeMutation(writes));
            } else {
                Assert.hardAssert(writeBatch.getWrites(i5).C(), "TransformMutation should be preceded by a patch or set mutation", new Object[0]);
                C1699E.b bVarF = C1699E.F(writes);
                Iterator it = writeBatch.getWrites(i6).v().l().iterator();
                while (it.hasNext()) {
                    bVarF.f((p.c) it.next());
                }
                arrayList2.add(this.rpcSerializer.decodeMutation((C1699E) bVarF.build()));
                i5 = i6;
            }
            i5++;
        }
        return new MutationBatch(batchId, timestampDecodeTimestamp, arrayList, arrayList2);
    }

    public TargetData decodeTargetData(Target target) {
        com.google.firebase.firestore.core.Target targetDecodeDocumentsTarget;
        int targetId = target.getTargetId();
        SnapshotVersion snapshotVersionDecodeVersion = this.rpcSerializer.decodeVersion(target.getSnapshotVersion());
        SnapshotVersion snapshotVersionDecodeVersion2 = this.rpcSerializer.decodeVersion(target.getLastLimboFreeSnapshotVersion());
        AbstractC1062i resumeToken = target.getResumeToken();
        long lastListenSequenceNumber = target.getLastListenSequenceNumber();
        int i4 = AnonymousClass1.$SwitchMap$com$google$firebase$firestore$proto$Target$TargetTypeCase[target.getTargetTypeCase().ordinal()];
        if (i4 == 1) {
            targetDecodeDocumentsTarget = this.rpcSerializer.decodeDocumentsTarget(target.getDocuments());
        } else {
            if (i4 != 2) {
                throw Assert.fail("Unknown targetType %d", target.getTargetTypeCase());
            }
            targetDecodeDocumentsTarget = this.rpcSerializer.decodeQueryTarget(target.getQuery());
        }
        return new TargetData(targetDecodeDocumentsTarget, targetId, lastListenSequenceNumber, QueryPurpose.LISTEN, snapshotVersionDecodeVersion, snapshotVersionDecodeVersion2, resumeToken, null);
    }

    public C1669a encodeBundledQuery(BundledQuery bundledQuery) {
        C1695A.d dVarEncodeQueryTarget = this.rpcSerializer.encodeQueryTarget(bundledQuery.getTarget());
        C1669a.b bVarQ = C1669a.q();
        bVarQ.f(bundledQuery.getLimitType().equals(Query.LimitType.LIMIT_TO_FIRST) ? C1669a.c.FIRST : C1669a.c.LAST);
        bVarQ.g(dVarEncodeQueryTarget.n());
        bVarQ.h(dVarEncodeQueryTarget.o());
        return (C1669a) bVarQ.build();
    }

    public C1632a encodeFieldIndexSegments(List<FieldIndex.Segment> list) {
        C1632a.b bVarP = C1632a.p();
        bVarP.g(C1632a.d.COLLECTION_GROUP);
        for (FieldIndex.Segment segment : list) {
            C1632a.c.b bVarQ = C1632a.c.q();
            bVarQ.g(segment.getFieldPath().canonicalString());
            if (segment.getKind() == FieldIndex.Segment.Kind.CONTAINS) {
                bVarQ.f(C1632a.c.EnumC0212a.CONTAINS);
            } else if (segment.getKind() == FieldIndex.Segment.Kind.ASCENDING) {
                bVarQ.h(C1632a.c.EnumC0214c.ASCENDING);
            } else {
                bVarQ.h(C1632a.c.EnumC0214c.DESCENDING);
            }
            bVarP.f(bVarQ);
        }
        return (C1632a) bVarP.build();
    }

    public MaybeDocument encodeMaybeDocument(Document document) {
        MaybeDocument.Builder builderNewBuilder = MaybeDocument.newBuilder();
        if (document.isNoDocument()) {
            builderNewBuilder.setNoDocument(encodeNoDocument(document));
        } else if (document.isFoundDocument()) {
            builderNewBuilder.setDocument(encodeDocument(document));
        } else {
            if (!document.isUnknownDocument()) {
                throw Assert.fail("Cannot encode invalid document %s", document);
            }
            builderNewBuilder.setUnknownDocument(encodeUnknownDocument(document));
        }
        builderNewBuilder.setHasCommittedMutations(document.hasCommittedMutations());
        return (MaybeDocument) builderNewBuilder.build();
    }

    public C1699E encodeMutation(Mutation mutation) {
        return this.rpcSerializer.encodeMutation(mutation);
    }

    public WriteBatch encodeMutationBatch(MutationBatch mutationBatch) {
        WriteBatch.Builder builderNewBuilder = WriteBatch.newBuilder();
        builderNewBuilder.setBatchId(mutationBatch.getBatchId());
        builderNewBuilder.setLocalWriteTime(this.rpcSerializer.encodeTimestamp(mutationBatch.getLocalWriteTime()));
        Iterator<Mutation> it = mutationBatch.getBaseMutations().iterator();
        while (it.hasNext()) {
            builderNewBuilder.addBaseWrites(this.rpcSerializer.encodeMutation(it.next()));
        }
        Iterator<Mutation> it2 = mutationBatch.getMutations().iterator();
        while (it2.hasNext()) {
            builderNewBuilder.addWrites(this.rpcSerializer.encodeMutation(it2.next()));
        }
        return (WriteBatch) builderNewBuilder.build();
    }

    public Target encodeTargetData(TargetData targetData) {
        QueryPurpose queryPurpose = QueryPurpose.LISTEN;
        Assert.hardAssert(queryPurpose.equals(targetData.getPurpose()), "Only queries with purpose %s may be stored, got %s", queryPurpose, targetData.getPurpose());
        Target.Builder builderNewBuilder = Target.newBuilder();
        builderNewBuilder.setTargetId(targetData.getTargetId()).setLastListenSequenceNumber(targetData.getSequenceNumber()).setLastLimboFreeSnapshotVersion(this.rpcSerializer.encodeVersion(targetData.getLastLimboFreeSnapshotVersion())).setSnapshotVersion(this.rpcSerializer.encodeVersion(targetData.getSnapshotVersion())).setResumeToken(targetData.getResumeToken());
        com.google.firebase.firestore.core.Target target = targetData.getTarget();
        if (target.isDocumentQuery()) {
            builderNewBuilder.setDocuments(this.rpcSerializer.encodeDocumentsTarget(target));
        } else {
            builderNewBuilder.setQuery(this.rpcSerializer.encodeQueryTarget(target));
        }
        return (Target) builderNewBuilder.build();
    }
}
