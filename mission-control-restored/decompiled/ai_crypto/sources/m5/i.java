package m5;

import Q4.a;
import android.content.Context;
import android.util.Log;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import k4.C2105D;
import m5.h;
import q5.AbstractC2563b;

/* JADX INFO: loaded from: classes2.dex */
public class i implements Q4.a, h.a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Context f19004c;

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f19005a;

        static {
            int[] iArr = new int[h.c.values().length];
            f19005a = iArr;
            try {
                iArr[h.c.ROOT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f19005a[h.c.MUSIC.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f19005a[h.c.PODCASTS.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f19005a[h.c.RINGTONES.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f19005a[h.c.ALARMS.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f19005a[h.c.NOTIFICATIONS.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f19005a[h.c.PICTURES.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f19005a[h.c.MOVIES.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f19005a[h.c.DOWNLOADS.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f19005a[h.c.DCIM.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f19005a[h.c.DOCUMENTS.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
        }
    }

    private void z(V4.b bVar, Context context) {
        try {
            h.a.c(bVar, this);
        } catch (Exception e7) {
            Log.e("PathProviderPlugin", "Received exception while setting up PathProviderPlugin", e7);
        }
        this.f19004c = context;
    }

    @Override // m5.h.a
    public List d() {
        ArrayList arrayList = new ArrayList();
        for (File file : this.f19004c.getExternalCacheDirs()) {
            if (file != null) {
                arrayList.add(file.getAbsolutePath());
            }
        }
        return arrayList;
    }

    @Override // m5.h.a
    public String i() {
        File externalFilesDir = this.f19004c.getExternalFilesDir(null);
        if (externalFilesDir == null) {
            return null;
        }
        return externalFilesDir.getAbsolutePath();
    }

    @Override // m5.h.a
    public String l() {
        return this.f19004c.getCacheDir().getPath();
    }

    @Override // m5.h.a
    public String m() {
        return this.f19004c.getCacheDir().getPath();
    }

    @Override // m5.h.a
    public String n() {
        return AbstractC2563b.c(this.f19004c);
    }

    @Override // Q4.a
    public void onAttachedToEngine(a.b bVar) {
        z(bVar.b(), bVar.a());
    }

    @Override // Q4.a
    public void onDetachedFromEngine(a.b bVar) {
        h.a.c(bVar.b(), null);
    }

    @Override // m5.h.a
    public String q() {
        return AbstractC2563b.d(this.f19004c);
    }

    @Override // m5.h.a
    public List s(h.c cVar) {
        ArrayList arrayList = new ArrayList();
        for (File file : this.f19004c.getExternalFilesDirs(y(cVar))) {
            if (file != null) {
                arrayList.add(file.getAbsolutePath());
            }
        }
        return arrayList;
    }

    public String y(h.c cVar) {
        switch (a.f19005a[cVar.ordinal()]) {
            case 1:
                return null;
            case 2:
                return "music";
            case 3:
                return "podcasts";
            case 4:
                return "ringtones";
            case 5:
                return "alarms";
            case 6:
                return "notifications";
            case 7:
                return "pictures";
            case 8:
                return "movies";
            case C2105D.ARRAY_VALUE_FIELD_NUMBER /* 9 */:
                return "downloads";
            case C2105D.TIMESTAMP_VALUE_FIELD_NUMBER /* 10 */:
                return "dcim";
            case 11:
                return "documents";
            default:
                throw new RuntimeException("Unrecognized directory: " + cVar);
        }
    }
}
