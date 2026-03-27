package com.google.firebase.firestore.remote;

import K2.l0;
import com.google.firebase.Timestamp;
import com.google.firebase.firestore.AggregateField;
import com.google.firebase.firestore.core.Bound;
import com.google.firebase.firestore.core.CompositeFilter;
import com.google.firebase.firestore.core.FieldFilter;
import com.google.firebase.firestore.core.Filter;
import com.google.firebase.firestore.core.OrderBy;
import com.google.firebase.firestore.core.Query;
import com.google.firebase.firestore.core.Target;
import com.google.firebase.firestore.local.QueryPurpose;
import com.google.firebase.firestore.local.TargetData;
import com.google.firebase.firestore.model.DatabaseId;
import com.google.firebase.firestore.model.DocumentKey;
import com.google.firebase.firestore.model.FieldPath;
import com.google.firebase.firestore.model.MutableDocument;
import com.google.firebase.firestore.model.ObjectValue;
import com.google.firebase.firestore.model.ResourcePath;
import com.google.firebase.firestore.model.SnapshotVersion;
import com.google.firebase.firestore.model.Values;
import com.google.firebase.firestore.model.mutation.ArrayTransformOperation;
import com.google.firebase.firestore.model.mutation.DeleteMutation;
import com.google.firebase.firestore.model.mutation.FieldMask;
import com.google.firebase.firestore.model.mutation.FieldTransform;
import com.google.firebase.firestore.model.mutation.Mutation;
import com.google.firebase.firestore.model.mutation.MutationResult;
import com.google.firebase.firestore.model.mutation.NumericIncrementTransformOperation;
import com.google.firebase.firestore.model.mutation.PatchMutation;
import com.google.firebase.firestore.model.mutation.Precondition;
import com.google.firebase.firestore.model.mutation.ServerTimestampOperation;
import com.google.firebase.firestore.model.mutation.SetMutation;
import com.google.firebase.firestore.model.mutation.TransformOperation;
import com.google.firebase.firestore.model.mutation.VerifyMutation;
import com.google.firebase.firestore.remote.WatchChange;
import com.google.firebase.firestore.util.Assert;
import com.google.protobuf.C1078z;
import com.google.protobuf.u0;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import p2.C1695A;
import p2.C1696B;
import p2.C1699E;
import p2.C1703I;
import p2.C1705b;
import p2.C1708e;
import p2.C1713j;
import p2.k;
import p2.n;
import p2.p;
import p2.t;
import p2.v;
import p2.y;
import p2.z;
import z2.C2007a;

/* JADX INFO: loaded from: classes.dex */
public final class RemoteSerializer {
    private final DatabaseId databaseId;
    private final String databaseName;

    /* JADX INFO: renamed from: com.google.firebase.firestore.remote.RemoteSerializer$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$firebase$firestore$core$CompositeFilter$Operator;
        static final /* synthetic */ int[] $SwitchMap$com$google$firebase$firestore$core$FieldFilter$Operator;
        static final /* synthetic */ int[] $SwitchMap$com$google$firebase$firestore$local$QueryPurpose;
        static final /* synthetic */ int[] $SwitchMap$com$google$firestore$v1$DocumentTransform$FieldTransform$TransformTypeCase;
        static final /* synthetic */ int[] $SwitchMap$com$google$firestore$v1$ListenResponse$ResponseTypeCase;
        static final /* synthetic */ int[] $SwitchMap$com$google$firestore$v1$Precondition$ConditionTypeCase;
        static final /* synthetic */ int[] $SwitchMap$com$google$firestore$v1$StructuredQuery$CompositeFilter$Operator;
        static final /* synthetic */ int[] $SwitchMap$com$google$firestore$v1$StructuredQuery$Direction;
        static final /* synthetic */ int[] $SwitchMap$com$google$firestore$v1$StructuredQuery$FieldFilter$Operator;
        static final /* synthetic */ int[] $SwitchMap$com$google$firestore$v1$StructuredQuery$Filter$FilterTypeCase;
        static final /* synthetic */ int[] $SwitchMap$com$google$firestore$v1$StructuredQuery$UnaryFilter$Operator;
        static final /* synthetic */ int[] $SwitchMap$com$google$firestore$v1$TargetChange$TargetChangeType;
        static final /* synthetic */ int[] $SwitchMap$com$google$firestore$v1$Write$OperationCase;

        static {
            int[] iArr = new int[t.c.values().length];
            $SwitchMap$com$google$firestore$v1$ListenResponse$ResponseTypeCase = iArr;
            try {
                iArr[t.c.TARGET_CHANGE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$google$firestore$v1$ListenResponse$ResponseTypeCase[t.c.DOCUMENT_CHANGE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$google$firestore$v1$ListenResponse$ResponseTypeCase[t.c.DOCUMENT_DELETE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$google$firestore$v1$ListenResponse$ResponseTypeCase[t.c.DOCUMENT_REMOVE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$google$firestore$v1$ListenResponse$ResponseTypeCase[t.c.FILTER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$google$firestore$v1$ListenResponse$ResponseTypeCase[t.c.RESPONSETYPE_NOT_SET.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            int[] iArr2 = new int[C1696B.c.values().length];
            $SwitchMap$com$google$firestore$v1$TargetChange$TargetChangeType = iArr2;
            try {
                iArr2[C1696B.c.NO_CHANGE.ordinal()] = 1;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$com$google$firestore$v1$TargetChange$TargetChangeType[C1696B.c.ADD.ordinal()] = 2;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$com$google$firestore$v1$TargetChange$TargetChangeType[C1696B.c.REMOVE.ordinal()] = 3;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$com$google$firestore$v1$TargetChange$TargetChangeType[C1696B.c.CURRENT.ordinal()] = 4;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                $SwitchMap$com$google$firestore$v1$TargetChange$TargetChangeType[C1696B.c.RESET.ordinal()] = 5;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                $SwitchMap$com$google$firestore$v1$TargetChange$TargetChangeType[C1696B.c.UNRECOGNIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused12) {
            }
            int[] iArr3 = new int[z.e.values().length];
            $SwitchMap$com$google$firestore$v1$StructuredQuery$Direction = iArr3;
            try {
                iArr3[z.e.ASCENDING.ordinal()] = 1;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                $SwitchMap$com$google$firestore$v1$StructuredQuery$Direction[z.e.DESCENDING.ordinal()] = 2;
            } catch (NoSuchFieldError unused14) {
            }
            int[] iArr4 = new int[z.f.b.values().length];
            $SwitchMap$com$google$firestore$v1$StructuredQuery$FieldFilter$Operator = iArr4;
            try {
                iArr4[z.f.b.LESS_THAN.ordinal()] = 1;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                $SwitchMap$com$google$firestore$v1$StructuredQuery$FieldFilter$Operator[z.f.b.LESS_THAN_OR_EQUAL.ordinal()] = 2;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                $SwitchMap$com$google$firestore$v1$StructuredQuery$FieldFilter$Operator[z.f.b.EQUAL.ordinal()] = 3;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                $SwitchMap$com$google$firestore$v1$StructuredQuery$FieldFilter$Operator[z.f.b.NOT_EQUAL.ordinal()] = 4;
            } catch (NoSuchFieldError unused18) {
            }
            try {
                $SwitchMap$com$google$firestore$v1$StructuredQuery$FieldFilter$Operator[z.f.b.GREATER_THAN_OR_EQUAL.ordinal()] = 5;
            } catch (NoSuchFieldError unused19) {
            }
            try {
                $SwitchMap$com$google$firestore$v1$StructuredQuery$FieldFilter$Operator[z.f.b.GREATER_THAN.ordinal()] = 6;
            } catch (NoSuchFieldError unused20) {
            }
            try {
                $SwitchMap$com$google$firestore$v1$StructuredQuery$FieldFilter$Operator[z.f.b.ARRAY_CONTAINS.ordinal()] = 7;
            } catch (NoSuchFieldError unused21) {
            }
            try {
                $SwitchMap$com$google$firestore$v1$StructuredQuery$FieldFilter$Operator[z.f.b.IN.ordinal()] = 8;
            } catch (NoSuchFieldError unused22) {
            }
            try {
                $SwitchMap$com$google$firestore$v1$StructuredQuery$FieldFilter$Operator[z.f.b.ARRAY_CONTAINS_ANY.ordinal()] = 9;
            } catch (NoSuchFieldError unused23) {
            }
            try {
                $SwitchMap$com$google$firestore$v1$StructuredQuery$FieldFilter$Operator[z.f.b.NOT_IN.ordinal()] = 10;
            } catch (NoSuchFieldError unused24) {
            }
            int[] iArr5 = new int[FieldFilter.Operator.values().length];
            $SwitchMap$com$google$firebase$firestore$core$FieldFilter$Operator = iArr5;
            try {
                iArr5[FieldFilter.Operator.LESS_THAN.ordinal()] = 1;
            } catch (NoSuchFieldError unused25) {
            }
            try {
                $SwitchMap$com$google$firebase$firestore$core$FieldFilter$Operator[FieldFilter.Operator.LESS_THAN_OR_EQUAL.ordinal()] = 2;
            } catch (NoSuchFieldError unused26) {
            }
            try {
                $SwitchMap$com$google$firebase$firestore$core$FieldFilter$Operator[FieldFilter.Operator.EQUAL.ordinal()] = 3;
            } catch (NoSuchFieldError unused27) {
            }
            try {
                $SwitchMap$com$google$firebase$firestore$core$FieldFilter$Operator[FieldFilter.Operator.NOT_EQUAL.ordinal()] = 4;
            } catch (NoSuchFieldError unused28) {
            }
            try {
                $SwitchMap$com$google$firebase$firestore$core$FieldFilter$Operator[FieldFilter.Operator.GREATER_THAN.ordinal()] = 5;
            } catch (NoSuchFieldError unused29) {
            }
            try {
                $SwitchMap$com$google$firebase$firestore$core$FieldFilter$Operator[FieldFilter.Operator.GREATER_THAN_OR_EQUAL.ordinal()] = 6;
            } catch (NoSuchFieldError unused30) {
            }
            try {
                $SwitchMap$com$google$firebase$firestore$core$FieldFilter$Operator[FieldFilter.Operator.ARRAY_CONTAINS.ordinal()] = 7;
            } catch (NoSuchFieldError unused31) {
            }
            try {
                $SwitchMap$com$google$firebase$firestore$core$FieldFilter$Operator[FieldFilter.Operator.IN.ordinal()] = 8;
            } catch (NoSuchFieldError unused32) {
            }
            try {
                $SwitchMap$com$google$firebase$firestore$core$FieldFilter$Operator[FieldFilter.Operator.ARRAY_CONTAINS_ANY.ordinal()] = 9;
            } catch (NoSuchFieldError unused33) {
            }
            try {
                $SwitchMap$com$google$firebase$firestore$core$FieldFilter$Operator[FieldFilter.Operator.NOT_IN.ordinal()] = 10;
            } catch (NoSuchFieldError unused34) {
            }
            int[] iArr6 = new int[z.k.b.values().length];
            $SwitchMap$com$google$firestore$v1$StructuredQuery$UnaryFilter$Operator = iArr6;
            try {
                iArr6[z.k.b.IS_NAN.ordinal()] = 1;
            } catch (NoSuchFieldError unused35) {
            }
            try {
                $SwitchMap$com$google$firestore$v1$StructuredQuery$UnaryFilter$Operator[z.k.b.IS_NULL.ordinal()] = 2;
            } catch (NoSuchFieldError unused36) {
            }
            try {
                $SwitchMap$com$google$firestore$v1$StructuredQuery$UnaryFilter$Operator[z.k.b.IS_NOT_NAN.ordinal()] = 3;
            } catch (NoSuchFieldError unused37) {
            }
            try {
                $SwitchMap$com$google$firestore$v1$StructuredQuery$UnaryFilter$Operator[z.k.b.IS_NOT_NULL.ordinal()] = 4;
            } catch (NoSuchFieldError unused38) {
            }
            int[] iArr7 = new int[z.h.b.values().length];
            $SwitchMap$com$google$firestore$v1$StructuredQuery$Filter$FilterTypeCase = iArr7;
            try {
                iArr7[z.h.b.COMPOSITE_FILTER.ordinal()] = 1;
            } catch (NoSuchFieldError unused39) {
            }
            try {
                $SwitchMap$com$google$firestore$v1$StructuredQuery$Filter$FilterTypeCase[z.h.b.FIELD_FILTER.ordinal()] = 2;
            } catch (NoSuchFieldError unused40) {
            }
            try {
                $SwitchMap$com$google$firestore$v1$StructuredQuery$Filter$FilterTypeCase[z.h.b.UNARY_FILTER.ordinal()] = 3;
            } catch (NoSuchFieldError unused41) {
            }
            int[] iArr8 = new int[z.d.b.values().length];
            $SwitchMap$com$google$firestore$v1$StructuredQuery$CompositeFilter$Operator = iArr8;
            try {
                iArr8[z.d.b.AND.ordinal()] = 1;
            } catch (NoSuchFieldError unused42) {
            }
            try {
                $SwitchMap$com$google$firestore$v1$StructuredQuery$CompositeFilter$Operator[z.d.b.OR.ordinal()] = 2;
            } catch (NoSuchFieldError unused43) {
            }
            int[] iArr9 = new int[CompositeFilter.Operator.values().length];
            $SwitchMap$com$google$firebase$firestore$core$CompositeFilter$Operator = iArr9;
            try {
                iArr9[CompositeFilter.Operator.AND.ordinal()] = 1;
            } catch (NoSuchFieldError unused44) {
            }
            try {
                $SwitchMap$com$google$firebase$firestore$core$CompositeFilter$Operator[CompositeFilter.Operator.OR.ordinal()] = 2;
            } catch (NoSuchFieldError unused45) {
            }
            int[] iArr10 = new int[QueryPurpose.values().length];
            $SwitchMap$com$google$firebase$firestore$local$QueryPurpose = iArr10;
            try {
                iArr10[QueryPurpose.LISTEN.ordinal()] = 1;
            } catch (NoSuchFieldError unused46) {
            }
            try {
                $SwitchMap$com$google$firebase$firestore$local$QueryPurpose[QueryPurpose.EXISTENCE_FILTER_MISMATCH.ordinal()] = 2;
            } catch (NoSuchFieldError unused47) {
            }
            try {
                $SwitchMap$com$google$firebase$firestore$local$QueryPurpose[QueryPurpose.EXISTENCE_FILTER_MISMATCH_BLOOM.ordinal()] = 3;
            } catch (NoSuchFieldError unused48) {
            }
            try {
                $SwitchMap$com$google$firebase$firestore$local$QueryPurpose[QueryPurpose.LIMBO_RESOLUTION.ordinal()] = 4;
            } catch (NoSuchFieldError unused49) {
            }
            int[] iArr11 = new int[p.c.EnumC0225c.values().length];
            $SwitchMap$com$google$firestore$v1$DocumentTransform$FieldTransform$TransformTypeCase = iArr11;
            try {
                iArr11[p.c.EnumC0225c.SET_TO_SERVER_VALUE.ordinal()] = 1;
            } catch (NoSuchFieldError unused50) {
            }
            try {
                $SwitchMap$com$google$firestore$v1$DocumentTransform$FieldTransform$TransformTypeCase[p.c.EnumC0225c.APPEND_MISSING_ELEMENTS.ordinal()] = 2;
            } catch (NoSuchFieldError unused51) {
            }
            try {
                $SwitchMap$com$google$firestore$v1$DocumentTransform$FieldTransform$TransformTypeCase[p.c.EnumC0225c.REMOVE_ALL_FROM_ARRAY.ordinal()] = 3;
            } catch (NoSuchFieldError unused52) {
            }
            try {
                $SwitchMap$com$google$firestore$v1$DocumentTransform$FieldTransform$TransformTypeCase[p.c.EnumC0225c.INCREMENT.ordinal()] = 4;
            } catch (NoSuchFieldError unused53) {
            }
            int[] iArr12 = new int[v.c.values().length];
            $SwitchMap$com$google$firestore$v1$Precondition$ConditionTypeCase = iArr12;
            try {
                iArr12[v.c.UPDATE_TIME.ordinal()] = 1;
            } catch (NoSuchFieldError unused54) {
            }
            try {
                $SwitchMap$com$google$firestore$v1$Precondition$ConditionTypeCase[v.c.EXISTS.ordinal()] = 2;
            } catch (NoSuchFieldError unused55) {
            }
            try {
                $SwitchMap$com$google$firestore$v1$Precondition$ConditionTypeCase[v.c.CONDITIONTYPE_NOT_SET.ordinal()] = 3;
            } catch (NoSuchFieldError unused56) {
            }
            int[] iArr13 = new int[C1699E.c.values().length];
            $SwitchMap$com$google$firestore$v1$Write$OperationCase = iArr13;
            try {
                iArr13[C1699E.c.UPDATE.ordinal()] = 1;
            } catch (NoSuchFieldError unused57) {
            }
            try {
                $SwitchMap$com$google$firestore$v1$Write$OperationCase[C1699E.c.DELETE.ordinal()] = 2;
            } catch (NoSuchFieldError unused58) {
            }
            try {
                $SwitchMap$com$google$firestore$v1$Write$OperationCase[C1699E.c.VERIFY.ordinal()] = 3;
            } catch (NoSuchFieldError unused59) {
            }
        }
    }

    public RemoteSerializer(DatabaseId databaseId) {
        this.databaseId = databaseId;
        this.databaseName = encodedDatabaseId(databaseId).canonicalString();
    }

    private FieldMask decodeDocumentMask(p2.n nVar) {
        int iP = nVar.p();
        HashSet hashSet = new HashSet(iP);
        for (int i4 = 0; i4 < iP; i4++) {
            hashSet.add(FieldPath.fromServerFormat(nVar.o(i4)));
        }
        return FieldMask.fromSet(hashSet);
    }

    private FieldFilter.Operator decodeFieldFilterOperator(z.f.b bVar) {
        switch (AnonymousClass1.$SwitchMap$com$google$firestore$v1$StructuredQuery$FieldFilter$Operator[bVar.ordinal()]) {
            case 1:
                return FieldFilter.Operator.LESS_THAN;
            case 2:
                return FieldFilter.Operator.LESS_THAN_OR_EQUAL;
            case 3:
                return FieldFilter.Operator.EQUAL;
            case 4:
                return FieldFilter.Operator.NOT_EQUAL;
            case 5:
                return FieldFilter.Operator.GREATER_THAN_OR_EQUAL;
            case 6:
                return FieldFilter.Operator.GREATER_THAN;
            case 7:
                return FieldFilter.Operator.ARRAY_CONTAINS;
            case 8:
                return FieldFilter.Operator.IN;
            case 9:
                return FieldFilter.Operator.ARRAY_CONTAINS_ANY;
            case 10:
                return FieldFilter.Operator.NOT_IN;
            default:
                throw Assert.fail("Unhandled FieldFilter.operator %d", bVar);
        }
    }

    private FieldTransform decodeFieldTransform(p.c cVar) {
        int i4 = AnonymousClass1.$SwitchMap$com$google$firestore$v1$DocumentTransform$FieldTransform$TransformTypeCase[cVar.u().ordinal()];
        if (i4 == 1) {
            Assert.hardAssert(cVar.t() == p.c.b.REQUEST_TIME, "Unknown transform setToServerValue: %s", cVar.t());
            return new FieldTransform(FieldPath.fromServerFormat(cVar.q()), ServerTimestampOperation.getInstance());
        }
        if (i4 == 2) {
            return new FieldTransform(FieldPath.fromServerFormat(cVar.q()), new ArrayTransformOperation.Union(cVar.p().a()));
        }
        if (i4 == 3) {
            return new FieldTransform(FieldPath.fromServerFormat(cVar.q()), new ArrayTransformOperation.Remove(cVar.s().a()));
        }
        if (i4 == 4) {
            return new FieldTransform(FieldPath.fromServerFormat(cVar.q()), new NumericIncrementTransformOperation(cVar.r()));
        }
        throw Assert.fail("Unknown FieldTransform proto: %s", cVar);
    }

    private List<Filter> decodeFilters(z.h hVar) {
        Filter filterDecodeFilter = decodeFilter(hVar);
        if (filterDecodeFilter instanceof CompositeFilter) {
            CompositeFilter compositeFilter = (CompositeFilter) filterDecodeFilter;
            if (compositeFilter.isFlatConjunction()) {
                return compositeFilter.getFilters();
            }
        }
        return Collections.singletonList(filterDecodeFilter);
    }

    private MutableDocument decodeFoundDocument(C1708e c1708e) {
        Assert.hardAssert(c1708e.n().equals(C1708e.c.FOUND), "Tried to deserialize a found document from a missing document.", new Object[0]);
        DocumentKey documentKeyDecodeKey = decodeKey(c1708e.l().getName());
        ObjectValue objectValueFromMap = ObjectValue.fromMap(c1708e.l().o());
        SnapshotVersion snapshotVersionDecodeVersion = decodeVersion(c1708e.l().q());
        Assert.hardAssert(!snapshotVersionDecodeVersion.equals(SnapshotVersion.NONE), "Got a document response with no snapshot version", new Object[0]);
        return MutableDocument.newFoundDocument(documentKeyDecodeKey, snapshotVersionDecodeVersion, objectValueFromMap);
    }

    private MutableDocument decodeMissingDocument(C1708e c1708e) {
        Assert.hardAssert(c1708e.n().equals(C1708e.c.MISSING), "Tried to deserialize a missing document from a found document.", new Object[0]);
        DocumentKey documentKeyDecodeKey = decodeKey(c1708e.m());
        SnapshotVersion snapshotVersionDecodeVersion = decodeVersion(c1708e.getReadTime());
        Assert.hardAssert(!snapshotVersionDecodeVersion.equals(SnapshotVersion.NONE), "Got a no document response with no snapshot version", new Object[0]);
        return MutableDocument.newNoDocument(documentKeyDecodeKey, snapshotVersionDecodeVersion);
    }

    private OrderBy decodeOrderBy(z.i iVar) {
        OrderBy.Direction direction;
        FieldPath fieldPathFromServerFormat = FieldPath.fromServerFormat(iVar.n().m());
        int i4 = AnonymousClass1.$SwitchMap$com$google$firestore$v1$StructuredQuery$Direction[iVar.m().ordinal()];
        if (i4 == 1) {
            direction = OrderBy.Direction.ASCENDING;
        } else {
            if (i4 != 2) {
                throw Assert.fail("Unrecognized direction %d", iVar.m());
            }
            direction = OrderBy.Direction.DESCENDING;
        }
        return OrderBy.getInstance(direction, fieldPathFromServerFormat);
    }

    private Precondition decodePrecondition(p2.v vVar) {
        int i4 = AnonymousClass1.$SwitchMap$com$google$firestore$v1$Precondition$ConditionTypeCase[vVar.m().ordinal()];
        if (i4 == 1) {
            return Precondition.updateTime(decodeVersion(vVar.p()));
        }
        if (i4 == 2) {
            return Precondition.exists(vVar.o());
        }
        if (i4 == 3) {
            return Precondition.NONE;
        }
        throw Assert.fail("Unknown precondition", new Object[0]);
    }

    private ResourcePath decodeQueryPath(String str) {
        ResourcePath resourcePathDecodeResourceName = decodeResourceName(str);
        return resourcePathDecodeResourceName.length() == 4 ? ResourcePath.EMPTY : extractLocalPathFromResourceName(resourcePathDecodeResourceName);
    }

    private ResourcePath decodeResourceName(String str) {
        ResourcePath resourcePathFromString = ResourcePath.fromString(str);
        Assert.hardAssert(isValidResourceName(resourcePathFromString), "Tried to deserialize invalid key %s", resourcePathFromString);
        return resourcePathFromString;
    }

    private Filter decodeUnaryFilter(z.k kVar) {
        FieldPath fieldPathFromServerFormat = FieldPath.fromServerFormat(kVar.n().m());
        int i4 = AnonymousClass1.$SwitchMap$com$google$firestore$v1$StructuredQuery$UnaryFilter$Operator[kVar.o().ordinal()];
        if (i4 == 1) {
            return FieldFilter.create(fieldPathFromServerFormat, FieldFilter.Operator.EQUAL, Values.NAN_VALUE);
        }
        if (i4 == 2) {
            return FieldFilter.create(fieldPathFromServerFormat, FieldFilter.Operator.EQUAL, Values.NULL_VALUE);
        }
        if (i4 == 3) {
            return FieldFilter.create(fieldPathFromServerFormat, FieldFilter.Operator.NOT_EQUAL, Values.NAN_VALUE);
        }
        if (i4 == 4) {
            return FieldFilter.create(fieldPathFromServerFormat, FieldFilter.Operator.NOT_EQUAL, Values.NULL_VALUE);
        }
        throw Assert.fail("Unrecognized UnaryFilter.operator %d", kVar.o());
    }

    private p2.n encodeDocumentMask(FieldMask fieldMask) {
        n.b bVarQ = p2.n.q();
        Iterator<FieldPath> it = fieldMask.getMask().iterator();
        while (it.hasNext()) {
            bVarQ.f(it.next().canonicalString());
        }
        return (p2.n) bVarQ.build();
    }

    private z.f.b encodeFieldFilterOperator(FieldFilter.Operator operator) {
        switch (AnonymousClass1.$SwitchMap$com$google$firebase$firestore$core$FieldFilter$Operator[operator.ordinal()]) {
            case 1:
                return z.f.b.LESS_THAN;
            case 2:
                return z.f.b.LESS_THAN_OR_EQUAL;
            case 3:
                return z.f.b.EQUAL;
            case 4:
                return z.f.b.NOT_EQUAL;
            case 5:
                return z.f.b.GREATER_THAN;
            case 6:
                return z.f.b.GREATER_THAN_OR_EQUAL;
            case 7:
                return z.f.b.ARRAY_CONTAINS;
            case 8:
                return z.f.b.IN;
            case 9:
                return z.f.b.ARRAY_CONTAINS_ANY;
            case 10:
                return z.f.b.NOT_IN;
            default:
                throw Assert.fail("Unknown operator %d", operator);
        }
    }

    private z.g encodeFieldPath(FieldPath fieldPath) {
        return (z.g) z.g.n().f(fieldPath.canonicalString()).build();
    }

    private p.c encodeFieldTransform(FieldTransform fieldTransform) {
        TransformOperation operation = fieldTransform.getOperation();
        if (operation instanceof ServerTimestampOperation) {
            return (p.c) p.c.v().g(fieldTransform.getFieldPath().canonicalString()).j(p.c.b.REQUEST_TIME).build();
        }
        if (operation instanceof ArrayTransformOperation.Union) {
            return (p.c) p.c.v().g(fieldTransform.getFieldPath().canonicalString()).f(C1705b.t().f(((ArrayTransformOperation.Union) operation).getElements())).build();
        }
        if (operation instanceof ArrayTransformOperation.Remove) {
            return (p.c) p.c.v().g(fieldTransform.getFieldPath().canonicalString()).i(C1705b.t().f(((ArrayTransformOperation.Remove) operation).getElements())).build();
        }
        if (operation instanceof NumericIncrementTransformOperation) {
            return (p.c) p.c.v().g(fieldTransform.getFieldPath().canonicalString()).h(((NumericIncrementTransformOperation) operation).getOperand()).build();
        }
        throw Assert.fail("Unknown transform: %s", operation);
    }

    private z.h encodeFilters(List<Filter> list) {
        return encodeFilter(new CompositeFilter(list, CompositeFilter.Operator.AND));
    }

    private String encodeLabel(QueryPurpose queryPurpose) {
        int i4 = AnonymousClass1.$SwitchMap$com$google$firebase$firestore$local$QueryPurpose[queryPurpose.ordinal()];
        if (i4 == 1) {
            return null;
        }
        if (i4 == 2) {
            return "existence-filter-mismatch";
        }
        if (i4 == 3) {
            return "existence-filter-mismatch-bloom";
        }
        if (i4 == 4) {
            return "limbo-document";
        }
        throw Assert.fail("Unrecognized query purpose: %s", queryPurpose);
    }

    private z.i encodeOrderBy(OrderBy orderBy) {
        z.i.a aVarO = z.i.o();
        if (orderBy.getDirection().equals(OrderBy.Direction.ASCENDING)) {
            aVarO.f(z.e.ASCENDING);
        } else {
            aVarO.f(z.e.DESCENDING);
        }
        aVarO.g(encodeFieldPath(orderBy.getField()));
        return (z.i) aVarO.build();
    }

    private p2.v encodePrecondition(Precondition precondition) {
        Assert.hardAssert(!precondition.isNone(), "Can't serialize an empty precondition", new Object[0]);
        v.b bVarQ = p2.v.q();
        if (precondition.getUpdateTime() != null) {
            return (p2.v) bVarQ.g(encodeVersion(precondition.getUpdateTime())).build();
        }
        if (precondition.getExists() != null) {
            return (p2.v) bVarQ.f(precondition.getExists().booleanValue()).build();
        }
        throw Assert.fail("Unknown Precondition", new Object[0]);
    }

    private String encodeQueryPath(ResourcePath resourcePath) {
        return encodeResourceName(this.databaseId, resourcePath);
    }

    private String encodeResourceName(DatabaseId databaseId, ResourcePath resourcePath) {
        return encodedDatabaseId(databaseId).append("documents").append(resourcePath).canonicalString();
    }

    private static ResourcePath encodedDatabaseId(DatabaseId databaseId) {
        return ResourcePath.fromSegments(Arrays.asList("projects", databaseId.getProjectId(), "databases", databaseId.getDatabaseId()));
    }

    private static ResourcePath extractLocalPathFromResourceName(ResourcePath resourcePath) {
        Assert.hardAssert(resourcePath.length() > 4 && resourcePath.getSegment(4).equals("documents"), "Tried to deserialize invalid key %s", resourcePath);
        return resourcePath.popFirst(5);
    }

    private l0 fromStatus(C2007a c2007a) {
        return l0.h(c2007a.k()).q(c2007a.m());
    }

    private static boolean isValidResourceName(ResourcePath resourcePath) {
        return resourcePath.length() >= 4 && resourcePath.getSegment(0).equals("projects") && resourcePath.getSegment(2).equals("databases");
    }

    public String databaseName() {
        return this.databaseName;
    }

    public CompositeFilter decodeCompositeFilter(z.d dVar) {
        ArrayList arrayList = new ArrayList();
        Iterator it = dVar.p().iterator();
        while (it.hasNext()) {
            arrayList.add(decodeFilter((z.h) it.next()));
        }
        return new CompositeFilter(arrayList, decodeCompositeFilterOperator(dVar.q()));
    }

    public CompositeFilter.Operator decodeCompositeFilterOperator(z.d.b bVar) {
        int i4 = AnonymousClass1.$SwitchMap$com$google$firestore$v1$StructuredQuery$CompositeFilter$Operator[bVar.ordinal()];
        if (i4 == 1) {
            return CompositeFilter.Operator.AND;
        }
        if (i4 == 2) {
            return CompositeFilter.Operator.OR;
        }
        throw Assert.fail("Only AND and OR composite filter types are supported.", new Object[0]);
    }

    public Target decodeDocumentsTarget(C1695A.c cVar) {
        int iP = cVar.p();
        Assert.hardAssert(iP == 1, "DocumentsTarget contained other than 1 document %d", Integer.valueOf(iP));
        return Query.atPath(decodeQueryPath(cVar.o(0))).toTarget();
    }

    public FieldFilter decodeFieldFilter(z.f fVar) {
        return FieldFilter.create(FieldPath.fromServerFormat(fVar.o().m()), decodeFieldFilterOperator(fVar.p()), fVar.q());
    }

    public Filter decodeFilter(z.h hVar) {
        int i4 = AnonymousClass1.$SwitchMap$com$google$firestore$v1$StructuredQuery$Filter$FilterTypeCase[hVar.q().ordinal()];
        if (i4 == 1) {
            return decodeCompositeFilter(hVar.n());
        }
        if (i4 == 2) {
            return decodeFieldFilter(hVar.p());
        }
        if (i4 == 3) {
            return decodeUnaryFilter(hVar.r());
        }
        throw Assert.fail("Unrecognized Filter.filterType %d", hVar.q());
    }

    public DocumentKey decodeKey(String str) {
        ResourcePath resourcePathDecodeResourceName = decodeResourceName(str);
        Assert.hardAssert(resourcePathDecodeResourceName.getSegment(1).equals(this.databaseId.getProjectId()), "Tried to deserialize key from different project.", new Object[0]);
        Assert.hardAssert(resourcePathDecodeResourceName.getSegment(3).equals(this.databaseId.getDatabaseId()), "Tried to deserialize key from different database.", new Object[0]);
        return DocumentKey.fromPath(extractLocalPathFromResourceName(resourcePathDecodeResourceName));
    }

    public MutableDocument decodeMaybeDocument(C1708e c1708e) {
        if (c1708e.n().equals(C1708e.c.FOUND)) {
            return decodeFoundDocument(c1708e);
        }
        if (c1708e.n().equals(C1708e.c.MISSING)) {
            return decodeMissingDocument(c1708e);
        }
        throw new IllegalArgumentException("Unknown result case: " + c1708e.n());
    }

    public Mutation decodeMutation(C1699E c1699e) {
        Precondition preconditionDecodePrecondition = c1699e.A() ? decodePrecondition(c1699e.s()) : Precondition.NONE;
        ArrayList arrayList = new ArrayList();
        Iterator it = c1699e.y().iterator();
        while (it.hasNext()) {
            arrayList.add(decodeFieldTransform((p.c) it.next()));
        }
        int i4 = AnonymousClass1.$SwitchMap$com$google$firestore$v1$Write$OperationCase[c1699e.u().ordinal()];
        if (i4 == 1) {
            return c1699e.D() ? new PatchMutation(decodeKey(c1699e.w().getName()), ObjectValue.fromMap(c1699e.w().o()), decodeDocumentMask(c1699e.x()), preconditionDecodePrecondition, arrayList) : new SetMutation(decodeKey(c1699e.w().getName()), ObjectValue.fromMap(c1699e.w().o()), preconditionDecodePrecondition, arrayList);
        }
        if (i4 == 2) {
            return new DeleteMutation(decodeKey(c1699e.t()), preconditionDecodePrecondition);
        }
        if (i4 == 3) {
            return new VerifyMutation(decodeKey(c1699e.z()), preconditionDecodePrecondition);
        }
        throw Assert.fail("Unknown mutation operation: %d", c1699e.u());
    }

    public MutationResult decodeMutationResult(C1703I c1703i, SnapshotVersion snapshotVersion) {
        SnapshotVersion snapshotVersionDecodeVersion = decodeVersion(c1703i.m());
        if (!SnapshotVersion.NONE.equals(snapshotVersionDecodeVersion)) {
            snapshotVersion = snapshotVersionDecodeVersion;
        }
        int iL = c1703i.l();
        ArrayList arrayList = new ArrayList(iL);
        for (int i4 = 0; i4 < iL; i4++) {
            arrayList.add(c1703i.k(i4));
        }
        return new MutationResult(snapshotVersion, arrayList);
    }

    public Target decodeQueryTarget(String str, p2.z zVar) {
        ResourcePath resourcePath;
        String strN;
        List arrayList;
        ResourcePath resourcePathDecodeQueryPath = decodeQueryPath(str);
        int iX = zVar.x();
        if (iX <= 0) {
            resourcePath = resourcePathDecodeQueryPath;
            strN = null;
        } else {
            Assert.hardAssert(iX == 1, "StructuredQuery.from with more than one collection is not supported.", new Object[0]);
            z.c cVarW = zVar.w(0);
            if (cVarW.m()) {
                resourcePath = resourcePathDecodeQueryPath;
                strN = cVarW.n();
            } else {
                resourcePathDecodeQueryPath = resourcePathDecodeQueryPath.append(cVarW.n());
                resourcePath = resourcePathDecodeQueryPath;
                strN = null;
            }
        }
        List<Filter> listDecodeFilters = zVar.G() ? decodeFilters(zVar.C()) : Collections.EMPTY_LIST;
        int iA = zVar.A();
        if (iA > 0) {
            arrayList = new ArrayList(iA);
            for (int i4 = 0; i4 < iA; i4++) {
                arrayList.add(decodeOrderBy(zVar.z(i4)));
            }
        } else {
            arrayList = Collections.EMPTY_LIST;
        }
        return new Target(resourcePath, strN, listDecodeFilters, arrayList, zVar.E() ? zVar.y().m() : -1L, zVar.F() ? new Bound(zVar.B().a(), zVar.B().o()) : null, zVar.D() ? new Bound(zVar.v().a(), !zVar.v().o()) : null);
    }

    public Timestamp decodeTimestamp(u0 u0Var) {
        return new Timestamp(u0Var.o(), u0Var.n());
    }

    public SnapshotVersion decodeVersion(u0 u0Var) {
        return (u0Var.o() == 0 && u0Var.n() == 0) ? SnapshotVersion.NONE : new SnapshotVersion(decodeTimestamp(u0Var));
    }

    public SnapshotVersion decodeVersionFromListenResponse(p2.t tVar) {
        return tVar.p() != t.c.TARGET_CHANGE ? SnapshotVersion.NONE : tVar.q().n() != 0 ? SnapshotVersion.NONE : decodeVersion(tVar.q().getReadTime());
    }

    public WatchChange decodeWatchChange(p2.t tVar) {
        WatchChange.WatchTargetChangeType watchTargetChangeType;
        int i4 = AnonymousClass1.$SwitchMap$com$google$firestore$v1$ListenResponse$ResponseTypeCase[tVar.p().ordinal()];
        l0 l0VarFromStatus = null;
        if (i4 == 1) {
            C1696B c1696bQ = tVar.q();
            int i5 = AnonymousClass1.$SwitchMap$com$google$firestore$v1$TargetChange$TargetChangeType[c1696bQ.m().ordinal()];
            if (i5 == 1) {
                watchTargetChangeType = WatchChange.WatchTargetChangeType.NoChange;
            } else if (i5 == 2) {
                watchTargetChangeType = WatchChange.WatchTargetChangeType.Added;
            } else if (i5 == 3) {
                watchTargetChangeType = WatchChange.WatchTargetChangeType.Removed;
                l0VarFromStatus = fromStatus(c1696bQ.k());
            } else if (i5 == 4) {
                watchTargetChangeType = WatchChange.WatchTargetChangeType.Current;
            } else {
                if (i5 != 5) {
                    throw new IllegalArgumentException("Unknown target change type");
                }
                watchTargetChangeType = WatchChange.WatchTargetChangeType.Reset;
            }
            return new WatchChange.WatchTargetChange(watchTargetChangeType, c1696bQ.o(), c1696bQ.getResumeToken(), l0VarFromStatus);
        }
        if (i4 == 2) {
            p2.l lVarL = tVar.l();
            List listM = lVarL.m();
            List listL = lVarL.l();
            DocumentKey documentKeyDecodeKey = decodeKey(lVarL.getDocument().getName());
            SnapshotVersion snapshotVersionDecodeVersion = decodeVersion(lVarL.getDocument().q());
            Assert.hardAssert(!snapshotVersionDecodeVersion.equals(SnapshotVersion.NONE), "Got a document change without an update time", new Object[0]);
            MutableDocument mutableDocumentNewFoundDocument = MutableDocument.newFoundDocument(documentKeyDecodeKey, snapshotVersionDecodeVersion, ObjectValue.fromMap(lVarL.getDocument().o()));
            return new WatchChange.DocumentChange(listM, listL, mutableDocumentNewFoundDocument.getKey(), mutableDocumentNewFoundDocument);
        }
        if (i4 == 3) {
            p2.m mVarM = tVar.m();
            List listM2 = mVarM.m();
            MutableDocument mutableDocumentNewNoDocument = MutableDocument.newNoDocument(decodeKey(mVarM.l()), decodeVersion(mVarM.getReadTime()));
            return new WatchChange.DocumentChange(Collections.EMPTY_LIST, listM2, mutableDocumentNewNoDocument.getKey(), mutableDocumentNewNoDocument);
        }
        if (i4 == 4) {
            p2.o oVarN = tVar.n();
            return new WatchChange.DocumentChange(Collections.EMPTY_LIST, oVarN.m(), decodeKey(oVarN.l()), null);
        }
        if (i4 != 5) {
            throw new IllegalArgumentException("Unknown change type set");
        }
        p2.q qVarO = tVar.o();
        return new WatchChange.ExistenceFilterWatchChange(qVarO.getTargetId(), new ExistenceFilter(qVarO.k(), qVarO.m()));
    }

    public z.h encodeCompositeFilter(CompositeFilter compositeFilter) {
        ArrayList arrayList = new ArrayList(compositeFilter.getFilters().size());
        Iterator<Filter> it = compositeFilter.getFilters().iterator();
        while (it.hasNext()) {
            arrayList.add(encodeFilter(it.next()));
        }
        if (arrayList.size() == 1) {
            return (z.h) arrayList.get(0);
        }
        z.d.a aVarR = z.d.r();
        aVarR.g(encodeCompositeFilterOperator(compositeFilter.getOperator()));
        aVarR.f(arrayList);
        return (z.h) z.h.s().f(aVarR).build();
    }

    public z.d.b encodeCompositeFilterOperator(CompositeFilter.Operator operator) {
        int i4 = AnonymousClass1.$SwitchMap$com$google$firebase$firestore$core$CompositeFilter$Operator[operator.ordinal()];
        if (i4 == 1) {
            return z.d.b.AND;
        }
        if (i4 == 2) {
            return z.d.b.OR;
        }
        throw Assert.fail("Unrecognized composite filter type.", new Object[0]);
    }

    public p2.k encodeDocument(DocumentKey documentKey, ObjectValue objectValue) {
        k.b bVarT = p2.k.t();
        bVarT.g(encodeKey(documentKey));
        bVarT.f(objectValue.getFieldsMap());
        return (p2.k) bVarT.build();
    }

    public C1695A.c encodeDocumentsTarget(Target target) {
        C1695A.c.a aVarQ = C1695A.c.q();
        aVarQ.f(encodeQueryPath(target.getPath()));
        return (C1695A.c) aVarQ.build();
    }

    public z.h encodeFilter(Filter filter) {
        if (filter instanceof FieldFilter) {
            return encodeUnaryOrFieldFilter((FieldFilter) filter);
        }
        if (filter instanceof CompositeFilter) {
            return encodeCompositeFilter((CompositeFilter) filter);
        }
        throw Assert.fail("Unrecognized filter type %s", filter.toString());
    }

    public String encodeKey(DocumentKey documentKey) {
        return encodeResourceName(this.databaseId, documentKey.getPath());
    }

    public Map<String, String> encodeListenRequestLabels(TargetData targetData) {
        String strEncodeLabel = encodeLabel(targetData.getPurpose());
        if (strEncodeLabel == null) {
            return null;
        }
        HashMap map = new HashMap(1);
        map.put("goog-listen-tags", strEncodeLabel);
        return map;
    }

    public C1699E encodeMutation(Mutation mutation) {
        C1699E.b bVarE = C1699E.E();
        if (mutation instanceof SetMutation) {
            bVarE.i(encodeDocument(mutation.getKey(), ((SetMutation) mutation).getValue()));
        } else if (mutation instanceof PatchMutation) {
            bVarE.i(encodeDocument(mutation.getKey(), ((PatchMutation) mutation).getValue()));
            bVarE.j(encodeDocumentMask(mutation.getFieldMask()));
        } else if (mutation instanceof DeleteMutation) {
            bVarE.h(encodeKey(mutation.getKey()));
        } else {
            if (!(mutation instanceof VerifyMutation)) {
                throw Assert.fail("unknown mutation type %s", mutation.getClass());
            }
            bVarE.k(encodeKey(mutation.getKey()));
        }
        Iterator<FieldTransform> it = mutation.getFieldTransforms().iterator();
        while (it.hasNext()) {
            bVarE.f(encodeFieldTransform(it.next()));
        }
        if (!mutation.getPrecondition().isNone()) {
            bVarE.g(encodePrecondition(mutation.getPrecondition()));
        }
        return (C1699E) bVarE.build();
    }

    public C1695A.d encodeQueryTarget(Target target) {
        C1695A.d.a aVarP = C1695A.d.p();
        z.b bVarH = p2.z.H();
        ResourcePath path = target.getPath();
        if (target.getCollectionGroup() != null) {
            Assert.hardAssert(path.length() % 2 == 0, "Collection Group queries should be within a document path or root.", new Object[0]);
            aVarP.f(encodeQueryPath(path));
            z.c.a aVarO = z.c.o();
            aVarO.g(target.getCollectionGroup());
            aVarO.f(true);
            bVarH.f(aVarO);
        } else {
            Assert.hardAssert(path.length() % 2 != 0, "Document queries with filters are not supported.", new Object[0]);
            aVarP.f(encodeQueryPath(path.popLast()));
            z.c.a aVarO2 = z.c.o();
            aVarO2.g(path.getLastSegment());
            bVarH.f(aVarO2);
        }
        if (target.getFilters().size() > 0) {
            bVarH.k(encodeFilters(target.getFilters()));
        }
        Iterator<OrderBy> it = target.getOrderBy().iterator();
        while (it.hasNext()) {
            bVarH.g(encodeOrderBy(it.next()));
        }
        if (target.hasLimit()) {
            bVarH.i(C1078z.n().f((int) target.getLimit()));
        }
        if (target.getStartAt() != null) {
            C1713j.b bVarQ = C1713j.q();
            bVarQ.f(target.getStartAt().getPosition());
            bVarQ.g(target.getStartAt().isInclusive());
            bVarH.j(bVarQ);
        }
        if (target.getEndAt() != null) {
            C1713j.b bVarQ2 = C1713j.q();
            bVarQ2.f(target.getEndAt().getPosition());
            bVarQ2.g(!target.getEndAt().isInclusive());
            bVarH.h(bVarQ2);
        }
        aVarP.g(bVarH);
        return (C1695A.d) aVarP.build();
    }

    public p2.y encodeStructuredAggregationQuery(C1695A.d dVar, List<AggregateField> list, HashMap<String, String> map) {
        y.c cVarO = p2.y.o();
        cVarO.g(dVar.o());
        ArrayList arrayList = new ArrayList();
        HashSet hashSet = new HashSet();
        int i4 = 1;
        for (AggregateField aggregateField : list) {
            if (!hashSet.contains(aggregateField.getAlias())) {
                hashSet.add(aggregateField.getAlias());
                StringBuilder sb = new StringBuilder();
                sb.append("aggregate_");
                int i5 = i4 + 1;
                sb.append(i4);
                String string = sb.toString();
                map.put(string, aggregateField.getAlias());
                y.b.C0227b c0227bO = y.b.o();
                z.g gVar = (z.g) z.g.n().f(aggregateField.getFieldPath()).build();
                if (aggregateField instanceof AggregateField.CountAggregateField) {
                    c0227bO.h(y.b.c.k());
                } else if (aggregateField instanceof AggregateField.SumAggregateField) {
                    c0227bO.i((y.b.d) y.b.d.l().f(gVar).build());
                } else {
                    if (!(aggregateField instanceof AggregateField.AverageAggregateField)) {
                        throw new RuntimeException("Unsupported aggregation");
                    }
                    c0227bO.g((y.b.a) y.b.a.l().f(gVar).build());
                }
                c0227bO.f(string);
                arrayList.add((y.b) c0227bO.build());
                i4 = i5;
            }
        }
        cVarO.f(arrayList);
        return (p2.y) cVarO.build();
    }

    public C1695A encodeTarget(TargetData targetData) {
        C1695A.b bVarQ = C1695A.q();
        Target target = targetData.getTarget();
        if (target.isDocumentQuery()) {
            bVarQ.f(encodeDocumentsTarget(target));
        } else {
            bVarQ.h(encodeQueryTarget(target));
        }
        bVarQ.k(targetData.getTargetId());
        if (!targetData.getResumeToken().isEmpty() || targetData.getSnapshotVersion().compareTo(SnapshotVersion.NONE) <= 0) {
            bVarQ.j(targetData.getResumeToken());
        } else {
            bVarQ.i(encodeTimestamp(targetData.getSnapshotVersion().getTimestamp()));
        }
        if (targetData.getExpectedCount() != null && (!targetData.getResumeToken().isEmpty() || targetData.getSnapshotVersion().compareTo(SnapshotVersion.NONE) > 0)) {
            bVarQ.g(C1078z.n().f(targetData.getExpectedCount().intValue()));
        }
        return (C1695A) bVarQ.build();
    }

    public u0 encodeTimestamp(Timestamp timestamp) {
        u0.b bVarP = u0.p();
        bVarP.g(timestamp.getSeconds());
        bVarP.f(timestamp.getNanoseconds());
        return (u0) bVarP.build();
    }

    public z.h encodeUnaryOrFieldFilter(FieldFilter fieldFilter) {
        FieldFilter.Operator operator = fieldFilter.getOperator();
        FieldFilter.Operator operator2 = FieldFilter.Operator.EQUAL;
        if (operator == operator2 || fieldFilter.getOperator() == FieldFilter.Operator.NOT_EQUAL) {
            z.k.a aVarP = z.k.p();
            aVarP.f(encodeFieldPath(fieldFilter.getField()));
            if (Values.isNanValue(fieldFilter.getValue())) {
                aVarP.g(fieldFilter.getOperator() == operator2 ? z.k.b.IS_NAN : z.k.b.IS_NOT_NAN);
                return (z.h) z.h.s().h(aVarP).build();
            }
            if (Values.isNullValue(fieldFilter.getValue())) {
                aVarP.g(fieldFilter.getOperator() == operator2 ? z.k.b.IS_NULL : z.k.b.IS_NOT_NULL);
                return (z.h) z.h.s().h(aVarP).build();
            }
        }
        z.f.a aVarR = z.f.r();
        aVarR.f(encodeFieldPath(fieldFilter.getField()));
        aVarR.g(encodeFieldFilterOperator(fieldFilter.getOperator()));
        aVarR.h(fieldFilter.getValue());
        return (z.h) z.h.s().g(aVarR).build();
    }

    public u0 encodeVersion(SnapshotVersion snapshotVersion) {
        return encodeTimestamp(snapshotVersion.getTimestamp());
    }

    public boolean isLocalResourceName(ResourcePath resourcePath) {
        return isValidResourceName(resourcePath) && resourcePath.getSegment(1).equals(this.databaseId.getProjectId()) && resourcePath.getSegment(3).equals(this.databaseId.getDatabaseId());
    }

    public Target decodeQueryTarget(C1695A.d dVar) {
        return decodeQueryTarget(dVar.n(), dVar.o());
    }
}
