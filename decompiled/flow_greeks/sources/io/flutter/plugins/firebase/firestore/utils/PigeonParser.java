package io.flutter.plugins.firebase.firestore.utils;

import android.util.Log;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.d;
import com.google.firebase.firestore.e;
import com.google.firebase.firestore.i;
import com.google.firebase.firestore.k;
import d9.d;
import d9.g;
import d9.s0;
import d9.s1;
import d9.t;
import d9.t1;
import io.flutter.plugins.firebase.firestore.GeneratedAndroidFirebaseFirestore;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public class PigeonParser {
    static final /* synthetic */ boolean $assertionsDisabled = false;

    /* JADX INFO: renamed from: io.flutter.plugins.firebase.firestore.utils.PigeonParser$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$firebase$firestore$DocumentChange$Type;
        static final /* synthetic */ int[] $SwitchMap$io$flutter$plugins$firebase$firestore$GeneratedAndroidFirebaseFirestore$AggregateSource;
        static final /* synthetic */ int[] $SwitchMap$io$flutter$plugins$firebase$firestore$GeneratedAndroidFirebaseFirestore$ListenSource;
        static final /* synthetic */ int[] $SwitchMap$io$flutter$plugins$firebase$firestore$GeneratedAndroidFirebaseFirestore$ServerTimestampBehavior;
        static final /* synthetic */ int[] $SwitchMap$io$flutter$plugins$firebase$firestore$GeneratedAndroidFirebaseFirestore$Source;

        static {
            int[] iArr = new int[GeneratedAndroidFirebaseFirestore.AggregateSource.values().length];
            $SwitchMap$io$flutter$plugins$firebase$firestore$GeneratedAndroidFirebaseFirestore$AggregateSource = iArr;
            try {
                iArr[GeneratedAndroidFirebaseFirestore.AggregateSource.SERVER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            int[] iArr2 = new int[GeneratedAndroidFirebaseFirestore.ListenSource.values().length];
            $SwitchMap$io$flutter$plugins$firebase$firestore$GeneratedAndroidFirebaseFirestore$ListenSource = iArr2;
            try {
                iArr2[GeneratedAndroidFirebaseFirestore.ListenSource.DEFAULT_SOURCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$io$flutter$plugins$firebase$firestore$GeneratedAndroidFirebaseFirestore$ListenSource[GeneratedAndroidFirebaseFirestore.ListenSource.CACHE.ordinal()] = 2;
            } catch (NoSuchFieldError unused3) {
            }
            int[] iArr3 = new int[g.b.values().length];
            $SwitchMap$com$google$firebase$firestore$DocumentChange$Type = iArr3;
            try {
                iArr3[g.b.ADDED.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$google$firebase$firestore$DocumentChange$Type[g.b.MODIFIED.ordinal()] = 2;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$google$firebase$firestore$DocumentChange$Type[g.b.REMOVED.ordinal()] = 3;
            } catch (NoSuchFieldError unused6) {
            }
            int[] iArr4 = new int[GeneratedAndroidFirebaseFirestore.ServerTimestampBehavior.values().length];
            $SwitchMap$io$flutter$plugins$firebase$firestore$GeneratedAndroidFirebaseFirestore$ServerTimestampBehavior = iArr4;
            try {
                iArr4[GeneratedAndroidFirebaseFirestore.ServerTimestampBehavior.NONE.ordinal()] = 1;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$io$flutter$plugins$firebase$firestore$GeneratedAndroidFirebaseFirestore$ServerTimestampBehavior[GeneratedAndroidFirebaseFirestore.ServerTimestampBehavior.ESTIMATE.ordinal()] = 2;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$io$flutter$plugins$firebase$firestore$GeneratedAndroidFirebaseFirestore$ServerTimestampBehavior[GeneratedAndroidFirebaseFirestore.ServerTimestampBehavior.PREVIOUS.ordinal()] = 3;
            } catch (NoSuchFieldError unused9) {
            }
            int[] iArr5 = new int[GeneratedAndroidFirebaseFirestore.Source.values().length];
            $SwitchMap$io$flutter$plugins$firebase$firestore$GeneratedAndroidFirebaseFirestore$Source = iArr5;
            try {
                iArr5[GeneratedAndroidFirebaseFirestore.Source.CACHE.ordinal()] = 1;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                $SwitchMap$io$flutter$plugins$firebase$firestore$GeneratedAndroidFirebaseFirestore$Source[GeneratedAndroidFirebaseFirestore.Source.SERVER_AND_CACHE.ordinal()] = 2;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                $SwitchMap$io$flutter$plugins$firebase$firestore$GeneratedAndroidFirebaseFirestore$Source[GeneratedAndroidFirebaseFirestore.Source.SERVER.ordinal()] = 3;
            } catch (NoSuchFieldError unused12) {
            }
        }
    }

    private static e filterFromJson(Map<String, Object> map) {
        t tVar;
        Object obj;
        if (!map.containsKey("fieldPath")) {
            String str = (String) map.get("op");
            List list = (List) map.get("queries");
            ArrayList arrayList = new ArrayList();
            Iterator it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(filterFromJson((Map) it.next()));
            }
            if (str.equals("OR")) {
                return e.l((e[]) arrayList.toArray(new e[0]));
            }
            if (str.equals("AND")) {
                return e.a((e[]) arrayList.toArray(new e[0]));
            }
            throw new Error("Invalid operator");
        }
        String str2 = (String) map.get("op");
        tVar = (t) map.get("fieldPath");
        obj = map.get("value");
        str2.getClass();
        switch (str2) {
            case "not-in":
                return e.k(tVar, (List) obj);
            case "<":
                return e.h(tVar, obj);
            case ">":
                return e.e(tVar, obj);
            case "!=":
                return e.j(tVar, obj);
            case "<=":
                return e.i(tVar, obj);
            case "==":
                return e.d(tVar, obj);
            case ">=":
                return e.f(tVar, obj);
            case "in":
                return e.g(tVar, (List) obj);
            case "array-contains":
                return e.b(tVar, obj);
            case "array-contains-any":
                return e.c(tVar, (List) obj);
            default:
                throw new Error("Invalid operator");
        }
    }

    public static d parseAggregateSource(GeneratedAndroidFirebaseFirestore.AggregateSource aggregateSource) {
        if (AnonymousClass1.$SwitchMap$io$flutter$plugins$firebase$firestore$GeneratedAndroidFirebaseFirestore$AggregateSource[aggregateSource.ordinal()] == 1) {
            return d.SERVER;
        }
        throw new IllegalArgumentException("Unknown AggregateSource value: " + aggregateSource);
    }

    public static List<t> parseFieldPath(List<List<String>> list) {
        ArrayList arrayList = new ArrayList(list.size());
        Iterator<List<String>> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(t.d((String[]) it.next().toArray(new String[0])));
        }
        return arrayList;
    }

    public static s0 parseListenSource(GeneratedAndroidFirebaseFirestore.ListenSource listenSource) {
        int i10 = AnonymousClass1.$SwitchMap$io$flutter$plugins$firebase$firestore$GeneratedAndroidFirebaseFirestore$ListenSource[listenSource.ordinal()];
        if (i10 == 1) {
            return s0.DEFAULT;
        }
        if (i10 == 2) {
            return s0.CACHE;
        }
        throw new IllegalArgumentException("Unknown ListenSource value: " + listenSource);
    }

    public static d.a parsePigeonServerTimestampBehavior(GeneratedAndroidFirebaseFirestore.ServerTimestampBehavior serverTimestampBehavior) {
        if (serverTimestampBehavior == null) {
            return d.a.NONE;
        }
        int i10 = AnonymousClass1.$SwitchMap$io$flutter$plugins$firebase$firestore$GeneratedAndroidFirebaseFirestore$ServerTimestampBehavior[serverTimestampBehavior.ordinal()];
        if (i10 == 1) {
            return d.a.NONE;
        }
        if (i10 == 2) {
            return d.a.ESTIMATE;
        }
        if (i10 == 3) {
            return d.a.PREVIOUS;
        }
        throw new IllegalArgumentException("Unknown server timestamp behavior: " + serverTimestampBehavior);
    }

    public static t1 parsePigeonSource(GeneratedAndroidFirebaseFirestore.Source source) {
        int i10 = AnonymousClass1.$SwitchMap$io$flutter$plugins$firebase$firestore$GeneratedAndroidFirebaseFirestore$Source[source.ordinal()];
        if (i10 == 1) {
            return t1.CACHE;
        }
        if (i10 == 2) {
            return t1.DEFAULT;
        }
        if (i10 == 3) {
            return t1.SERVER;
        }
        throw new IllegalArgumentException("Unknown source: " + source);
    }

    public static i parseQuery(FirebaseFirestore firebaseFirestore, String str, boolean z10, GeneratedAndroidFirebaseFirestore.PigeonQueryParameters pigeonQueryParameters) {
        try {
            i iVarW = z10 ? firebaseFirestore.w(str) : firebaseFirestore.v(str);
            if (pigeonQueryParameters == null) {
                return iVarW;
            }
            if (pigeonQueryParameters.getFilters() != null) {
                iVarW = iVarW.G(filterFromJson(pigeonQueryParameters.getFilters()));
            }
            List<List<Object>> where = pigeonQueryParameters.getWhere();
            Objects.requireNonNull(where);
            for (List<Object> list : where) {
                t tVar = (t) list.get(0);
                String str2 = (String) list.get(1);
                Object obj = list.get(2);
                if ("==".equals(str2)) {
                    iVarW = iVarW.J(tVar, obj);
                } else if ("!=".equals(str2)) {
                    iVarW = iVarW.P(tVar, obj);
                } else if ("<".equals(str2)) {
                    iVarW = iVarW.N(tVar, obj);
                } else if ("<=".equals(str2)) {
                    iVarW = iVarW.O(tVar, obj);
                } else if (">".equals(str2)) {
                    iVarW = iVarW.K(tVar, obj);
                } else if (">=".equals(str2)) {
                    iVarW = iVarW.L(tVar, obj);
                } else if ("array-contains".equals(str2)) {
                    iVarW = iVarW.H(tVar, obj);
                } else if ("array-contains-any".equals(str2)) {
                    iVarW = iVarW.I(tVar, (List) obj);
                } else if ("in".equals(str2)) {
                    iVarW = iVarW.M(tVar, (List) obj);
                } else if ("not-in".equals(str2)) {
                    iVarW = iVarW.Q(tVar, (List) obj);
                } else {
                    Log.w("FLTFirestoreMsgCodec", "An invalid query operator " + str2 + " was received but not handled.");
                }
            }
            Long limit = pigeonQueryParameters.getLimit();
            if (limit != null) {
                iVarW = iVarW.s(limit.longValue());
            }
            Long limitToLast = pigeonQueryParameters.getLimitToLast();
            if (limitToLast != null) {
                iVarW = iVarW.t(limitToLast.longValue());
            }
            List<List<Object>> orderBy = pigeonQueryParameters.getOrderBy();
            if (orderBy == null) {
                return iVarW;
            }
            for (List<Object> list2 : orderBy) {
                iVarW = iVarW.u((t) list2.get(0), ((Boolean) list2.get(1)).booleanValue() ? i.c.DESCENDING : i.c.ASCENDING);
            }
            List<Object> startAt = pigeonQueryParameters.getStartAt();
            if (startAt != null) {
                Object[] array = startAt.toArray();
                Objects.requireNonNull(array);
                iVarW = iVarW.B(array);
            }
            List<Object> startAfter = pigeonQueryParameters.getStartAfter();
            if (startAfter != null) {
                Object[] array2 = startAfter.toArray();
                Objects.requireNonNull(array2);
                iVarW = iVarW.A(array2);
            }
            List<Object> endAt = pigeonQueryParameters.getEndAt();
            if (endAt != null) {
                Object[] array3 = endAt.toArray();
                Objects.requireNonNull(array3);
                iVarW = iVarW.l(array3);
            }
            List<Object> endBefore = pigeonQueryParameters.getEndBefore();
            if (endBefore == null) {
                return iVarW;
            }
            Object[] array4 = endBefore.toArray();
            Objects.requireNonNull(array4);
            return iVarW.m(array4);
        } catch (Exception e10) {
            Log.e("FLTFirestoreMsgCodec", "An error occurred while parsing query arguments, this is most likely an error with this SDK.", e10);
            return null;
        }
    }

    public static GeneratedAndroidFirebaseFirestore.PigeonDocumentChange toPigeonDocumentChange(g gVar, d.a aVar) {
        GeneratedAndroidFirebaseFirestore.PigeonDocumentChange.Builder builder = new GeneratedAndroidFirebaseFirestore.PigeonDocumentChange.Builder();
        builder.setType(toPigeonDocumentChangeType(gVar.e()));
        builder.setOldIndex(Long.valueOf(gVar.d()));
        builder.setNewIndex(Long.valueOf(gVar.c()));
        builder.setDocument(toPigeonDocumentSnapshot(gVar.b(), aVar));
        return builder.build();
    }

    public static GeneratedAndroidFirebaseFirestore.DocumentChangeType toPigeonDocumentChangeType(g.b bVar) {
        int i10 = AnonymousClass1.$SwitchMap$com$google$firebase$firestore$DocumentChange$Type[bVar.ordinal()];
        if (i10 == 1) {
            return GeneratedAndroidFirebaseFirestore.DocumentChangeType.ADDED;
        }
        if (i10 == 2) {
            return GeneratedAndroidFirebaseFirestore.DocumentChangeType.MODIFIED;
        }
        if (i10 == 3) {
            return GeneratedAndroidFirebaseFirestore.DocumentChangeType.REMOVED;
        }
        throw new IllegalArgumentException("Unknown change type: " + bVar);
    }

    public static List<GeneratedAndroidFirebaseFirestore.PigeonDocumentChange> toPigeonDocumentChanges(List<g> list, d.a aVar) {
        ArrayList arrayList = new ArrayList(list.size());
        Iterator<g> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(toPigeonDocumentChange(it.next(), aVar));
        }
        return arrayList;
    }

    public static GeneratedAndroidFirebaseFirestore.PigeonDocumentSnapshot toPigeonDocumentSnapshot(com.google.firebase.firestore.d dVar, d.a aVar) {
        GeneratedAndroidFirebaseFirestore.PigeonDocumentSnapshot.Builder builder = new GeneratedAndroidFirebaseFirestore.PigeonDocumentSnapshot.Builder();
        builder.setMetadata(toPigeonSnapshotMetadata(dVar.f()));
        builder.setData(dVar.e(aVar));
        builder.setPath(dVar.g().r());
        return builder.build();
    }

    public static List<GeneratedAndroidFirebaseFirestore.PigeonDocumentSnapshot> toPigeonDocumentSnapshots(List<com.google.firebase.firestore.d> list, d.a aVar) {
        ArrayList arrayList = new ArrayList(list.size());
        Iterator<com.google.firebase.firestore.d> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(toPigeonDocumentSnapshot(it.next(), aVar));
        }
        return arrayList;
    }

    public static GeneratedAndroidFirebaseFirestore.PigeonQuerySnapshot toPigeonQuerySnapshot(k kVar, d.a aVar) {
        GeneratedAndroidFirebaseFirestore.PigeonQuerySnapshot.Builder builder = new GeneratedAndroidFirebaseFirestore.PigeonQuerySnapshot.Builder();
        builder.setMetadata(toPigeonSnapshotMetadata(kVar.g()));
        builder.setDocumentChanges(toPigeonDocumentChanges(kVar.d(), aVar));
        builder.setDocuments(toPigeonDocumentSnapshots(kVar.f(), aVar));
        return builder.build();
    }

    public static GeneratedAndroidFirebaseFirestore.PigeonSnapshotMetadata toPigeonSnapshotMetadata(s1 s1Var) {
        GeneratedAndroidFirebaseFirestore.PigeonSnapshotMetadata.Builder builder = new GeneratedAndroidFirebaseFirestore.PigeonSnapshotMetadata.Builder();
        builder.setHasPendingWrites(Boolean.valueOf(s1Var.a()));
        builder.setIsFromCache(Boolean.valueOf(s1Var.b()));
        return builder.build();
    }
}
