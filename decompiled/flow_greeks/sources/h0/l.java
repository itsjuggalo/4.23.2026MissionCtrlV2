package h0;

import android.os.Bundle;
import androidx.core.graphics.drawable.IconCompat;
import h0.i;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public abstract class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Object f10881a = new Object();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Object f10882b = new Object();

    public static Bundle a(i.a aVar) {
        Bundle bundle = new Bundle();
        IconCompat iconCompatD = aVar.d();
        bundle.putInt("icon", iconCompatD != null ? iconCompatD.m() : 0);
        bundle.putCharSequence(com.amazon.a.a.o.b.S, aVar.h());
        bundle.putParcelable("actionIntent", aVar.a());
        Bundle bundle2 = aVar.c() != null ? new Bundle(aVar.c()) : new Bundle();
        bundle2.putBoolean("android.support.allowGeneratedReplies", aVar.b());
        bundle.putBundle("extras", bundle2);
        bundle.putParcelableArray("remoteInputs", c(aVar.e()));
        bundle.putBoolean("showsUserInterface", aVar.g());
        bundle.putInt("semanticAction", aVar.f());
        return bundle;
    }

    public static Bundle b(s sVar) {
        Bundle bundle = new Bundle();
        bundle.putString("resultKey", sVar.i());
        bundle.putCharSequence("label", sVar.h());
        bundle.putCharSequenceArray("choices", sVar.e());
        bundle.putBoolean("allowFreeFormInput", sVar.c());
        bundle.putBundle("extras", sVar.g());
        Set setD = sVar.d();
        if (setD != null && !setD.isEmpty()) {
            ArrayList<String> arrayList = new ArrayList<>(setD.size());
            Iterator it = setD.iterator();
            while (it.hasNext()) {
                arrayList.add((String) it.next());
            }
            bundle.putStringArrayList("allowedDataTypes", arrayList);
        }
        return bundle;
    }

    public static Bundle[] c(s[] sVarArr) {
        if (sVarArr == null) {
            return null;
        }
        Bundle[] bundleArr = new Bundle[sVarArr.length];
        for (int i10 = 0; i10 < sVarArr.length; i10++) {
            bundleArr[i10] = b(sVarArr[i10]);
        }
        return bundleArr;
    }
}
