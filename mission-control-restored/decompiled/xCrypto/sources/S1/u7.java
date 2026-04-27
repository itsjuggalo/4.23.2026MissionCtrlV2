package S1;

import com.google.android.gms.internal.measurement.zzhf;
import com.google.android.gms.internal.measurement.zzhg;
import com.google.android.gms.internal.measurement.zzhp;
import com.google.android.gms.internal.measurement.zzhq;
import com.google.android.gms.internal.measurement.zzih;
import com.google.android.gms.internal.measurement.zzii;
import com.google.android.gms.internal.measurement.zzij;
import com.google.android.gms.internal.measurement.zzik;
import com.google.android.gms.internal.measurement.zzpq;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import u.C1853a;

/* JADX INFO: loaded from: classes.dex */
public final class u7 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f4982a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f4983b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public zzii f4984c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public BitSet f4985d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public BitSet f4986e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Map f4987f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Map f4988g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final /* synthetic */ C0558e f4989h;

    public /* synthetic */ u7(C0558e c0558e, String str, zzii zziiVar, BitSet bitSet, BitSet bitSet2, Map map, Map map2, byte[] bArr) {
        Objects.requireNonNull(c0558e);
        this.f4989h = c0558e;
        this.f4982a = str;
        this.f4985d = bitSet;
        this.f4986e = bitSet2;
        this.f4987f = map;
        this.f4988g = new C1853a();
        for (Integer num : map2.keySet()) {
            ArrayList arrayList = new ArrayList();
            arrayList.add((Long) map2.get(num));
            this.f4988g.put(num, arrayList);
        }
        this.f4983b = false;
        this.f4984c = zziiVar;
    }

    public final void a(AbstractC0542c abstractC0542c) {
        int iA = abstractC0542c.a();
        if (abstractC0542c.f4418c != null) {
            this.f4986e.set(iA, true);
        }
        Boolean bool = abstractC0542c.f4419d;
        if (bool != null) {
            this.f4985d.set(iA, bool.booleanValue());
        }
        if (abstractC0542c.f4420e != null) {
            Map map = this.f4987f;
            Integer numValueOf = Integer.valueOf(iA);
            Long l4 = (Long) map.get(numValueOf);
            long jLongValue = abstractC0542c.f4420e.longValue() / 1000;
            if (l4 == null || jLongValue > l4.longValue()) {
                this.f4987f.put(numValueOf, Long.valueOf(jLongValue));
            }
        }
        if (abstractC0542c.f4421f != null) {
            Map map2 = this.f4988g;
            Integer numValueOf2 = Integer.valueOf(iA);
            List arrayList = (List) map2.get(numValueOf2);
            if (arrayList == null) {
                arrayList = new ArrayList();
                this.f4988g.put(numValueOf2, arrayList);
            }
            if (abstractC0542c.b()) {
                arrayList.clear();
            }
            zzpq.zza();
            C0658q3 c0658q3 = this.f4989h.f4245a;
            C0622m c0622mW = c0658q3.w();
            String str = this.f4982a;
            C0561e2 c0561e2 = AbstractC0569f2.f4515G0;
            if (c0622mW.H(str, c0561e2) && abstractC0542c.c()) {
                arrayList.clear();
            }
            zzpq.zza();
            if (!c0658q3.w().H(this.f4982a, c0561e2)) {
                arrayList.add(Long.valueOf(abstractC0542c.f4421f.longValue() / 1000));
                return;
            }
            Long lValueOf = Long.valueOf(abstractC0542c.f4421f.longValue() / 1000);
            if (arrayList.contains(lValueOf)) {
                return;
            }
            arrayList.add(lValueOf);
        }
    }

    public final zzhg b(int i4) {
        ArrayList arrayList;
        List list;
        zzhf zzhfVarZzh = zzhg.zzh();
        zzhfVarZzh.zza(i4);
        zzhfVarZzh.zzd(this.f4983b);
        zzii zziiVar = this.f4984c;
        if (zziiVar != null) {
            zzhfVarZzh.zzc(zziiVar);
        }
        zzih zzihVarZzi = zzii.zzi();
        zzihVarZzi.zzc(g7.Q(this.f4985d));
        zzihVarZzi.zza(g7.Q(this.f4986e));
        Map map = this.f4987f;
        if (map == null) {
            arrayList = null;
        } else {
            ArrayList arrayList2 = new ArrayList(map.size());
            for (Integer num : this.f4987f.keySet()) {
                int iIntValue = num.intValue();
                Long l4 = (Long) this.f4987f.get(num);
                if (l4 != null) {
                    zzhp zzhpVarZze = zzhq.zze();
                    zzhpVarZze.zza(iIntValue);
                    zzhpVarZze.zzb(l4.longValue());
                    arrayList2.add((zzhq) zzhpVarZze.zzbc());
                }
            }
            arrayList = arrayList2;
        }
        if (arrayList != null) {
            zzihVarZzi.zze(arrayList);
        }
        Map map2 = this.f4988g;
        if (map2 == null) {
            list = Collections.EMPTY_LIST;
        } else {
            ArrayList arrayList3 = new ArrayList(map2.size());
            for (Integer num2 : this.f4988g.keySet()) {
                zzij zzijVarZzf = zzik.zzf();
                zzijVarZzf.zza(num2.intValue());
                List list2 = (List) this.f4988g.get(num2);
                if (list2 != null) {
                    Collections.sort(list2);
                    zzijVarZzf.zzb(list2);
                }
                arrayList3.add((zzik) zzijVarZzf.zzbc());
            }
            list = arrayList3;
        }
        zzihVarZzi.zzg(list);
        zzhfVarZzh.zzb(zzihVarZzi);
        return (zzhg) zzhfVarZzh.zzbc();
    }

    public final /* synthetic */ BitSet c() {
        return this.f4985d;
    }

    public /* synthetic */ u7(C0558e c0558e, String str, byte[] bArr) {
        Objects.requireNonNull(c0558e);
        this.f4989h = c0558e;
        this.f4982a = str;
        this.f4983b = true;
        this.f4985d = new BitSet();
        this.f4986e = new BitSet();
        this.f4987f = new C1853a();
        this.f4988g = new C1853a();
    }
}
