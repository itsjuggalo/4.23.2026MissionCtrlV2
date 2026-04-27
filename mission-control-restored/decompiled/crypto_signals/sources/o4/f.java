package o4;

import N1.C0149z;
import P3.AbstractActivityC0229d;
import Z.B;
import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.Build;
import e4.C0572k;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import u.AbstractC1196k;

/* JADX INFO: loaded from: classes.dex */
public final class f implements Z3.s, Z3.u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f8686a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AbstractActivityC0229d f8687b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final B f8688c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Y3.j f8689d;
    public final B e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final C0572k f8690f;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final C0149z f8691k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final ExecutorService f8692l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f8693m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public Uri f8694n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public f.d f8695o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final Object f8696p;

    public f(AbstractActivityC0229d abstractActivityC0229d, B b3, Y3.j jVar) {
        B b6 = new B(abstractActivityC0229d, 17);
        C0572k c0572k = new C0572k();
        c0572k.f6318a = abstractActivityC0229d;
        C0149z c0149z = new C0149z(29);
        ExecutorService executorServiceNewSingleThreadExecutor = Executors.newSingleThreadExecutor();
        this.f8696p = new Object();
        this.f8687b = abstractActivityC0229d;
        this.f8688c = b3;
        this.f8686a = abstractActivityC0229d.getPackageName() + ".flutter.image_provider";
        this.e = b6;
        this.f8690f = c0572k;
        this.f8691k = c0149z;
        this.f8689d = jVar;
        this.f8692l = executorServiceNewSingleThreadExecutor;
    }

    public static void a(l4.d dVar) {
        dVar.c(new l("already_active", "Image picker is already active"));
    }

    public final void b(String str, String str2) {
        l4.d dVar;
        synchronized (this.f8696p) {
            f.d dVar2 = this.f8695o;
            dVar = dVar2 != null ? (l4.d) dVar2.f6384d : null;
            this.f8695o = null;
        }
        if (dVar == null) {
            this.f8689d.J(null, str, str2);
        } else {
            dVar.c(new l(str, str2));
        }
    }

    public final void c(ArrayList arrayList) {
        l4.d dVar;
        synchronized (this.f8696p) {
            f.d dVar2 = this.f8695o;
            dVar = dVar2 != null ? (l4.d) dVar2.f6384d : null;
            this.f8695o = null;
        }
        if (dVar == null) {
            this.f8689d.J(arrayList, null, null);
        } else {
            dVar.f(arrayList);
        }
    }

    public final void d(String str) {
        l4.d dVar;
        ArrayList arrayList = new ArrayList();
        if (str != null) {
            arrayList.add(str);
        }
        synchronized (this.f8696p) {
            f.d dVar2 = this.f8695o;
            dVar = dVar2 != null ? (l4.d) dVar2.f6384d : null;
            this.f8695o = null;
        }
        if (dVar != null) {
            dVar.f(arrayList);
        } else {
            if (arrayList.isEmpty()) {
                return;
            }
            this.f8689d.J(arrayList, null, null);
        }
    }

    public final ArrayList e(Intent intent, boolean z6) {
        ArrayList arrayList = new ArrayList();
        Uri data = intent.getData();
        C0149z c0149z = this.f8691k;
        AbstractActivityC0229d abstractActivityC0229d = this.f8687b;
        if (data != null) {
            c0149z.getClass();
            String strG = C0149z.g(abstractActivityC0229d, data);
            if (strG != null) {
                arrayList.add(new e(strG, null));
                return arrayList;
            }
        } else if (intent.getClipData() != null) {
            for (int i = 0; i < intent.getClipData().getItemCount(); i++) {
                Uri uri = intent.getClipData().getItemAt(i).getUri();
                if (uri != null) {
                    c0149z.getClass();
                    String strG2 = C0149z.g(abstractActivityC0229d, uri);
                    if (strG2 != null) {
                        arrayList.add(new e(strG2, z6 ? abstractActivityC0229d.getContentResolver().getType(uri) : null));
                    }
                }
            }
            return arrayList;
        }
        return null;
    }

    public final void f(Intent intent, Uri uri) {
        AbstractActivityC0229d abstractActivityC0229d = this.f8687b;
        PackageManager packageManager = abstractActivityC0229d.getPackageManager();
        Iterator<ResolveInfo> it = (Build.VERSION.SDK_INT >= 33 ? packageManager.queryIntentActivities(intent, PackageManager.ResolveInfoFlags.of(65536L)) : packageManager.queryIntentActivities(intent, 65536)).iterator();
        while (it.hasNext()) {
            abstractActivityC0229d.grantUriPermission(it.next().activityInfo.packageName, uri, 3);
        }
    }

    public final void g(ArrayList arrayList) {
        o oVar;
        synchronized (this.f8696p) {
            f.d dVar = this.f8695o;
            oVar = dVar != null ? (o) dVar.f6383c : null;
        }
        ArrayList arrayList2 = new ArrayList();
        int i = 0;
        if (oVar == null) {
            while (i < arrayList.size()) {
                arrayList2.add(((e) arrayList.get(i)).f8684a);
                i++;
            }
            c(arrayList2);
            return;
        }
        while (i < arrayList.size()) {
            e eVar = (e) arrayList.get(i);
            String strS = eVar.f8684a;
            String str = eVar.f8685b;
            if (str == null || !str.startsWith("video/")) {
                strS = this.f8688c.s(eVar.f8684a, oVar.f8716a, oVar.f8717b, oVar.f8718c.intValue());
            }
            arrayList2.add(strS);
            i++;
        }
        c(arrayList2);
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final void h() {
        Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
        if (this.f8693m == 2) {
            int i = Build.VERSION.SDK_INT;
            intent.putExtra("android.intent.extras.CAMERA_FACING", 0);
            if (i >= 26) {
                intent.putExtra("android.intent.extra.USE_FRONT_CAMERA", true);
            }
        }
        String string = UUID.randomUUID().toString();
        AbstractActivityC0229d abstractActivityC0229d = this.f8687b;
        File cacheDir = abstractActivityC0229d.getCacheDir();
        try {
            cacheDir.mkdirs();
            File fileCreateTempFile = File.createTempFile(string, ".jpg", cacheDir);
            this.f8694n = Uri.parse("file:" + fileCreateTempFile.getAbsolutePath());
            Uri uriD = AbstractC1196k.d(this.f8690f.f6318a, this.f8686a, fileCreateTempFile);
            intent.putExtra("output", uriD);
            f(intent, uriD);
            try {
                try {
                    abstractActivityC0229d.startActivityForResult(intent, 2343);
                } catch (ActivityNotFoundException unused) {
                    fileCreateTempFile.delete();
                    b("no_available_camera", "No cameras available for taking pictures.");
                }
            } catch (SecurityException e) {
                e.printStackTrace();
                b("no_available_camera", "No cameras available for taking pictures.");
            }
        } catch (IOException e2) {
            throw new RuntimeException(e2);
        }
    }

    public final void i() {
        u uVar;
        Long l6;
        Intent intent = new Intent("android.media.action.VIDEO_CAPTURE");
        synchronized (this.f8696p) {
            f.d dVar = this.f8695o;
            uVar = dVar != null ? (u) dVar.f6382b : null;
        }
        if (uVar != null && (l6 = uVar.f8727a) != null) {
            intent.putExtra("android.intent.extra.durationLimit", l6.intValue());
        }
        if (this.f8693m == 2) {
            int i = Build.VERSION.SDK_INT;
            intent.putExtra("android.intent.extras.CAMERA_FACING", 0);
            if (i >= 26) {
                intent.putExtra("android.intent.extra.USE_FRONT_CAMERA", true);
            }
        }
        String string = UUID.randomUUID().toString();
        File cacheDir = this.f8687b.getCacheDir();
        try {
            cacheDir.mkdirs();
            File fileCreateTempFile = File.createTempFile(string, ".mp4", cacheDir);
            this.f8694n = Uri.parse("file:" + fileCreateTempFile.getAbsolutePath());
            Uri uriD = AbstractC1196k.d(this.f8690f.f6318a, this.f8686a, fileCreateTempFile);
            intent.putExtra("output", uriD);
            f(intent, uriD);
            try {
                try {
                    this.f8687b.startActivityForResult(intent, 2353);
                } catch (ActivityNotFoundException unused) {
                    fileCreateTempFile.delete();
                    b("no_available_camera", "No cameras available for taking pictures.");
                }
            } catch (SecurityException e) {
                e.printStackTrace();
                b("no_available_camera", "No cameras available for taking pictures.");
            }
        } catch (IOException e2) {
            throw new RuntimeException(e2);
        }
    }

    public final boolean j() {
        B b3 = this.e;
        if (b3 == null) {
            return false;
        }
        AbstractActivityC0229d abstractActivityC0229d = (AbstractActivityC0229d) b3.f3700b;
        int i = Build.VERSION.SDK_INT;
        try {
            PackageManager packageManager = abstractActivityC0229d.getPackageManager();
            return Arrays.asList((i >= 33 ? packageManager.getPackageInfo(abstractActivityC0229d.getPackageName(), PackageManager.PackageInfoFlags.of(4096L)) : packageManager.getPackageInfo(abstractActivityC0229d.getPackageName(), 4096)).requestedPermissions).contains("android.permission.CAMERA");
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return false;
        }
    }

    public final boolean k(o oVar, u uVar, l4.d dVar) {
        synchronized (this.f8696p) {
            try {
                if (this.f8695o != null) {
                    return false;
                }
                this.f8695o = new f.d(oVar, uVar, dVar, 7);
                ((Activity) this.f8689d.f3665b).getSharedPreferences("flutter_image_picker_shared_preference", 0).edit().clear().apply();
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // Z3.s
    public final boolean onActivityResult(int i, final int i6, final Intent intent) {
        Runnable runnable;
        if (i == 2342) {
            final int i7 = 0;
            runnable = new Runnable(this) { // from class: o4.a

                /* JADX INFO: renamed from: b, reason: collision with root package name */
                public final /* synthetic */ f f8675b;

                {
                    this.f8675b = this;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    Intent intent2;
                    Intent intent3;
                    Intent intent4;
                    Intent intent5;
                    Intent intent6;
                    switch (i7) {
                        case 0:
                            f fVar = this.f8675b;
                            fVar.getClass();
                            if (i6 == -1 && (intent2 = intent) != null) {
                                ArrayList arrayListE = fVar.e(intent2, false);
                                if (arrayListE != null) {
                                    fVar.g(arrayListE);
                                } else {
                                    fVar.b("no_valid_image_uri", "Cannot find the selected image.");
                                }
                            } else {
                                fVar.d(null);
                            }
                            break;
                        case 1:
                            f fVar2 = this.f8675b;
                            fVar2.getClass();
                            if (i6 == -1 && (intent3 = intent) != null) {
                                ArrayList arrayListE2 = fVar2.e(intent3, false);
                                if (arrayListE2 != null) {
                                    fVar2.g(arrayListE2);
                                } else {
                                    fVar2.b("missing_valid_image_uri", "Cannot find at least one of the selected images.");
                                }
                            } else {
                                fVar2.d(null);
                            }
                            break;
                        case 2:
                            f fVar3 = this.f8675b;
                            fVar3.getClass();
                            if (i6 == -1 && (intent4 = intent) != null) {
                                ArrayList arrayListE3 = fVar3.e(intent4, false);
                                if (arrayListE3 != null) {
                                    fVar3.g(arrayListE3);
                                } else {
                                    fVar3.b("missing_valid_video_uri", "Cannot find at least one of the selected videos.");
                                }
                            } else {
                                fVar3.d(null);
                            }
                            break;
                        case 3:
                            f fVar4 = this.f8675b;
                            fVar4.getClass();
                            if (i6 == -1 && (intent5 = intent) != null) {
                                ArrayList arrayListE4 = fVar4.e(intent5, true);
                                if (arrayListE4 != null) {
                                    fVar4.g(arrayListE4);
                                } else {
                                    fVar4.b("no_valid_media_uri", "Cannot find the selected media.");
                                }
                            } else {
                                fVar4.d(null);
                            }
                            break;
                        default:
                            f fVar5 = this.f8675b;
                            fVar5.getClass();
                            if (i6 == -1 && (intent6 = intent) != null) {
                                ArrayList arrayListE5 = fVar5.e(intent6, false);
                                if (arrayListE5 != null && arrayListE5.size() >= 1) {
                                    fVar5.d(((e) arrayListE5.get(0)).f8684a);
                                } else {
                                    fVar5.b("no_valid_video_uri", "Cannot find the selected video.");
                                }
                            } else {
                                fVar5.d(null);
                            }
                            break;
                    }
                }
            };
        } else if (i == 2343) {
            final int i8 = 0;
            runnable = new Runnable(this) { // from class: o4.b

                /* JADX INFO: renamed from: b, reason: collision with root package name */
                public final /* synthetic */ f f8679b;

                {
                    this.f8679b = this;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    switch (i8) {
                        case 0:
                            int i9 = i6;
                            f fVar = this.f8679b;
                            if (i9 != -1) {
                                fVar.d(null);
                            } else {
                                Uri uri = fVar.f8694n;
                                if (uri == null) {
                                    uri = Uri.parse(((Activity) fVar.f8689d.f3665b).getSharedPreferences("flutter_image_picker_shared_preference", 0).getString("flutter_image_picker_pending_image_uri", ""));
                                }
                                final c cVar = new c(fVar, 0);
                                C0572k c0572k = fVar.f8690f;
                                c0572k.getClass();
                                MediaScannerConnection.scanFile(c0572k.f6318a, new String[]{uri != null ? uri.getPath() : ""}, null, new MediaScannerConnection.OnScanCompletedListener() { // from class: o4.d
                                    @Override // android.media.MediaScannerConnection.OnScanCompletedListener
                                    public final void onScanCompleted(String str, Uri uri2) {
                                        o oVar;
                                        c cVar2 = cVar;
                                        int i10 = cVar2.f8681a;
                                        f fVar2 = cVar2.f8682b;
                                        switch (i10) {
                                            case 0:
                                                synchronized (fVar2.f8696p) {
                                                    f.d dVar = fVar2.f8695o;
                                                    oVar = dVar != null ? (o) dVar.f6383c : null;
                                                    break;
                                                }
                                                if (oVar == null) {
                                                    fVar2.d(str);
                                                    return;
                                                }
                                                String strS = fVar2.f8688c.s(str, oVar.f8716a, oVar.f8717b, oVar.f8718c.intValue());
                                                if (strS != null && !strS.equals(str)) {
                                                    new File(str).delete();
                                                }
                                                fVar2.d(strS);
                                                return;
                                            default:
                                                fVar2.d(str);
                                                return;
                                        }
                                    }
                                });
                            }
                            break;
                        default:
                            int i10 = i6;
                            f fVar2 = this.f8679b;
                            if (i10 != -1) {
                                fVar2.d(null);
                            } else {
                                Uri uri2 = fVar2.f8694n;
                                if (uri2 == null) {
                                    uri2 = Uri.parse(((Activity) fVar2.f8689d.f3665b).getSharedPreferences("flutter_image_picker_shared_preference", 0).getString("flutter_image_picker_pending_image_uri", ""));
                                }
                                final c cVar2 = new c(fVar2, 1);
                                C0572k c0572k2 = fVar2.f8690f;
                                c0572k2.getClass();
                                MediaScannerConnection.scanFile(c0572k2.f6318a, new String[]{uri2 != null ? uri2.getPath() : ""}, null, new MediaScannerConnection.OnScanCompletedListener() { // from class: o4.d
                                    @Override // android.media.MediaScannerConnection.OnScanCompletedListener
                                    public final void onScanCompleted(String str, Uri uri22) {
                                        o oVar;
                                        c cVar22 = cVar2;
                                        int i102 = cVar22.f8681a;
                                        f fVar22 = cVar22.f8682b;
                                        switch (i102) {
                                            case 0:
                                                synchronized (fVar22.f8696p) {
                                                    f.d dVar = fVar22.f8695o;
                                                    oVar = dVar != null ? (o) dVar.f6383c : null;
                                                    break;
                                                }
                                                if (oVar == null) {
                                                    fVar22.d(str);
                                                    return;
                                                }
                                                String strS = fVar22.f8688c.s(str, oVar.f8716a, oVar.f8717b, oVar.f8718c.intValue());
                                                if (strS != null && !strS.equals(str)) {
                                                    new File(str).delete();
                                                }
                                                fVar22.d(strS);
                                                return;
                                            default:
                                                fVar22.d(str);
                                                return;
                                        }
                                    }
                                });
                            }
                            break;
                    }
                }
            };
        } else if (i == 2352) {
            final int i9 = 4;
            runnable = new Runnable(this) { // from class: o4.a

                /* JADX INFO: renamed from: b, reason: collision with root package name */
                public final /* synthetic */ f f8675b;

                {
                    this.f8675b = this;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    Intent intent2;
                    Intent intent3;
                    Intent intent4;
                    Intent intent5;
                    Intent intent6;
                    switch (i9) {
                        case 0:
                            f fVar = this.f8675b;
                            fVar.getClass();
                            if (i6 == -1 && (intent2 = intent) != null) {
                                ArrayList arrayListE = fVar.e(intent2, false);
                                if (arrayListE != null) {
                                    fVar.g(arrayListE);
                                } else {
                                    fVar.b("no_valid_image_uri", "Cannot find the selected image.");
                                }
                            } else {
                                fVar.d(null);
                            }
                            break;
                        case 1:
                            f fVar2 = this.f8675b;
                            fVar2.getClass();
                            if (i6 == -1 && (intent3 = intent) != null) {
                                ArrayList arrayListE2 = fVar2.e(intent3, false);
                                if (arrayListE2 != null) {
                                    fVar2.g(arrayListE2);
                                } else {
                                    fVar2.b("missing_valid_image_uri", "Cannot find at least one of the selected images.");
                                }
                            } else {
                                fVar2.d(null);
                            }
                            break;
                        case 2:
                            f fVar3 = this.f8675b;
                            fVar3.getClass();
                            if (i6 == -1 && (intent4 = intent) != null) {
                                ArrayList arrayListE3 = fVar3.e(intent4, false);
                                if (arrayListE3 != null) {
                                    fVar3.g(arrayListE3);
                                } else {
                                    fVar3.b("missing_valid_video_uri", "Cannot find at least one of the selected videos.");
                                }
                            } else {
                                fVar3.d(null);
                            }
                            break;
                        case 3:
                            f fVar4 = this.f8675b;
                            fVar4.getClass();
                            if (i6 == -1 && (intent5 = intent) != null) {
                                ArrayList arrayListE4 = fVar4.e(intent5, true);
                                if (arrayListE4 != null) {
                                    fVar4.g(arrayListE4);
                                } else {
                                    fVar4.b("no_valid_media_uri", "Cannot find the selected media.");
                                }
                            } else {
                                fVar4.d(null);
                            }
                            break;
                        default:
                            f fVar5 = this.f8675b;
                            fVar5.getClass();
                            if (i6 == -1 && (intent6 = intent) != null) {
                                ArrayList arrayListE5 = fVar5.e(intent6, false);
                                if (arrayListE5 != null && arrayListE5.size() >= 1) {
                                    fVar5.d(((e) arrayListE5.get(0)).f8684a);
                                } else {
                                    fVar5.b("no_valid_video_uri", "Cannot find the selected video.");
                                }
                            } else {
                                fVar5.d(null);
                            }
                            break;
                    }
                }
            };
        } else if (i != 2353) {
            switch (i) {
                case 2346:
                    final int i10 = 1;
                    runnable = new Runnable(this) { // from class: o4.a

                        /* JADX INFO: renamed from: b, reason: collision with root package name */
                        public final /* synthetic */ f f8675b;

                        {
                            this.f8675b = this;
                        }

                        @Override // java.lang.Runnable
                        public final void run() {
                            Intent intent2;
                            Intent intent3;
                            Intent intent4;
                            Intent intent5;
                            Intent intent6;
                            switch (i10) {
                                case 0:
                                    f fVar = this.f8675b;
                                    fVar.getClass();
                                    if (i6 == -1 && (intent2 = intent) != null) {
                                        ArrayList arrayListE = fVar.e(intent2, false);
                                        if (arrayListE != null) {
                                            fVar.g(arrayListE);
                                        } else {
                                            fVar.b("no_valid_image_uri", "Cannot find the selected image.");
                                        }
                                    } else {
                                        fVar.d(null);
                                    }
                                    break;
                                case 1:
                                    f fVar2 = this.f8675b;
                                    fVar2.getClass();
                                    if (i6 == -1 && (intent3 = intent) != null) {
                                        ArrayList arrayListE2 = fVar2.e(intent3, false);
                                        if (arrayListE2 != null) {
                                            fVar2.g(arrayListE2);
                                        } else {
                                            fVar2.b("missing_valid_image_uri", "Cannot find at least one of the selected images.");
                                        }
                                    } else {
                                        fVar2.d(null);
                                    }
                                    break;
                                case 2:
                                    f fVar3 = this.f8675b;
                                    fVar3.getClass();
                                    if (i6 == -1 && (intent4 = intent) != null) {
                                        ArrayList arrayListE3 = fVar3.e(intent4, false);
                                        if (arrayListE3 != null) {
                                            fVar3.g(arrayListE3);
                                        } else {
                                            fVar3.b("missing_valid_video_uri", "Cannot find at least one of the selected videos.");
                                        }
                                    } else {
                                        fVar3.d(null);
                                    }
                                    break;
                                case 3:
                                    f fVar4 = this.f8675b;
                                    fVar4.getClass();
                                    if (i6 == -1 && (intent5 = intent) != null) {
                                        ArrayList arrayListE4 = fVar4.e(intent5, true);
                                        if (arrayListE4 != null) {
                                            fVar4.g(arrayListE4);
                                        } else {
                                            fVar4.b("no_valid_media_uri", "Cannot find the selected media.");
                                        }
                                    } else {
                                        fVar4.d(null);
                                    }
                                    break;
                                default:
                                    f fVar5 = this.f8675b;
                                    fVar5.getClass();
                                    if (i6 == -1 && (intent6 = intent) != null) {
                                        ArrayList arrayListE5 = fVar5.e(intent6, false);
                                        if (arrayListE5 != null && arrayListE5.size() >= 1) {
                                            fVar5.d(((e) arrayListE5.get(0)).f8684a);
                                        } else {
                                            fVar5.b("no_valid_video_uri", "Cannot find the selected video.");
                                        }
                                    } else {
                                        fVar5.d(null);
                                    }
                                    break;
                            }
                        }
                    };
                    break;
                case 2347:
                    final int i11 = 3;
                    runnable = new Runnable(this) { // from class: o4.a

                        /* JADX INFO: renamed from: b, reason: collision with root package name */
                        public final /* synthetic */ f f8675b;

                        {
                            this.f8675b = this;
                        }

                        @Override // java.lang.Runnable
                        public final void run() {
                            Intent intent2;
                            Intent intent3;
                            Intent intent4;
                            Intent intent5;
                            Intent intent6;
                            switch (i11) {
                                case 0:
                                    f fVar = this.f8675b;
                                    fVar.getClass();
                                    if (i6 == -1 && (intent2 = intent) != null) {
                                        ArrayList arrayListE = fVar.e(intent2, false);
                                        if (arrayListE != null) {
                                            fVar.g(arrayListE);
                                        } else {
                                            fVar.b("no_valid_image_uri", "Cannot find the selected image.");
                                        }
                                    } else {
                                        fVar.d(null);
                                    }
                                    break;
                                case 1:
                                    f fVar2 = this.f8675b;
                                    fVar2.getClass();
                                    if (i6 == -1 && (intent3 = intent) != null) {
                                        ArrayList arrayListE2 = fVar2.e(intent3, false);
                                        if (arrayListE2 != null) {
                                            fVar2.g(arrayListE2);
                                        } else {
                                            fVar2.b("missing_valid_image_uri", "Cannot find at least one of the selected images.");
                                        }
                                    } else {
                                        fVar2.d(null);
                                    }
                                    break;
                                case 2:
                                    f fVar3 = this.f8675b;
                                    fVar3.getClass();
                                    if (i6 == -1 && (intent4 = intent) != null) {
                                        ArrayList arrayListE3 = fVar3.e(intent4, false);
                                        if (arrayListE3 != null) {
                                            fVar3.g(arrayListE3);
                                        } else {
                                            fVar3.b("missing_valid_video_uri", "Cannot find at least one of the selected videos.");
                                        }
                                    } else {
                                        fVar3.d(null);
                                    }
                                    break;
                                case 3:
                                    f fVar4 = this.f8675b;
                                    fVar4.getClass();
                                    if (i6 == -1 && (intent5 = intent) != null) {
                                        ArrayList arrayListE4 = fVar4.e(intent5, true);
                                        if (arrayListE4 != null) {
                                            fVar4.g(arrayListE4);
                                        } else {
                                            fVar4.b("no_valid_media_uri", "Cannot find the selected media.");
                                        }
                                    } else {
                                        fVar4.d(null);
                                    }
                                    break;
                                default:
                                    f fVar5 = this.f8675b;
                                    fVar5.getClass();
                                    if (i6 == -1 && (intent6 = intent) != null) {
                                        ArrayList arrayListE5 = fVar5.e(intent6, false);
                                        if (arrayListE5 != null && arrayListE5.size() >= 1) {
                                            fVar5.d(((e) arrayListE5.get(0)).f8684a);
                                        } else {
                                            fVar5.b("no_valid_video_uri", "Cannot find the selected video.");
                                        }
                                    } else {
                                        fVar5.d(null);
                                    }
                                    break;
                            }
                        }
                    };
                    break;
                case 2348:
                    final int i12 = 2;
                    runnable = new Runnable(this) { // from class: o4.a

                        /* JADX INFO: renamed from: b, reason: collision with root package name */
                        public final /* synthetic */ f f8675b;

                        {
                            this.f8675b = this;
                        }

                        @Override // java.lang.Runnable
                        public final void run() {
                            Intent intent2;
                            Intent intent3;
                            Intent intent4;
                            Intent intent5;
                            Intent intent6;
                            switch (i12) {
                                case 0:
                                    f fVar = this.f8675b;
                                    fVar.getClass();
                                    if (i6 == -1 && (intent2 = intent) != null) {
                                        ArrayList arrayListE = fVar.e(intent2, false);
                                        if (arrayListE != null) {
                                            fVar.g(arrayListE);
                                        } else {
                                            fVar.b("no_valid_image_uri", "Cannot find the selected image.");
                                        }
                                    } else {
                                        fVar.d(null);
                                    }
                                    break;
                                case 1:
                                    f fVar2 = this.f8675b;
                                    fVar2.getClass();
                                    if (i6 == -1 && (intent3 = intent) != null) {
                                        ArrayList arrayListE2 = fVar2.e(intent3, false);
                                        if (arrayListE2 != null) {
                                            fVar2.g(arrayListE2);
                                        } else {
                                            fVar2.b("missing_valid_image_uri", "Cannot find at least one of the selected images.");
                                        }
                                    } else {
                                        fVar2.d(null);
                                    }
                                    break;
                                case 2:
                                    f fVar3 = this.f8675b;
                                    fVar3.getClass();
                                    if (i6 == -1 && (intent4 = intent) != null) {
                                        ArrayList arrayListE3 = fVar3.e(intent4, false);
                                        if (arrayListE3 != null) {
                                            fVar3.g(arrayListE3);
                                        } else {
                                            fVar3.b("missing_valid_video_uri", "Cannot find at least one of the selected videos.");
                                        }
                                    } else {
                                        fVar3.d(null);
                                    }
                                    break;
                                case 3:
                                    f fVar4 = this.f8675b;
                                    fVar4.getClass();
                                    if (i6 == -1 && (intent5 = intent) != null) {
                                        ArrayList arrayListE4 = fVar4.e(intent5, true);
                                        if (arrayListE4 != null) {
                                            fVar4.g(arrayListE4);
                                        } else {
                                            fVar4.b("no_valid_media_uri", "Cannot find the selected media.");
                                        }
                                    } else {
                                        fVar4.d(null);
                                    }
                                    break;
                                default:
                                    f fVar5 = this.f8675b;
                                    fVar5.getClass();
                                    if (i6 == -1 && (intent6 = intent) != null) {
                                        ArrayList arrayListE5 = fVar5.e(intent6, false);
                                        if (arrayListE5 != null && arrayListE5.size() >= 1) {
                                            fVar5.d(((e) arrayListE5.get(0)).f8684a);
                                        } else {
                                            fVar5.b("no_valid_video_uri", "Cannot find the selected video.");
                                        }
                                    } else {
                                        fVar5.d(null);
                                    }
                                    break;
                            }
                        }
                    };
                    break;
                default:
                    return false;
            }
        } else {
            final int i13 = 1;
            runnable = new Runnable(this) { // from class: o4.b

                /* JADX INFO: renamed from: b, reason: collision with root package name */
                public final /* synthetic */ f f8679b;

                {
                    this.f8679b = this;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    switch (i13) {
                        case 0:
                            int i92 = i6;
                            f fVar = this.f8679b;
                            if (i92 != -1) {
                                fVar.d(null);
                            } else {
                                Uri uri = fVar.f8694n;
                                if (uri == null) {
                                    uri = Uri.parse(((Activity) fVar.f8689d.f3665b).getSharedPreferences("flutter_image_picker_shared_preference", 0).getString("flutter_image_picker_pending_image_uri", ""));
                                }
                                final c cVar = new c(fVar, 0);
                                C0572k c0572k = fVar.f8690f;
                                c0572k.getClass();
                                MediaScannerConnection.scanFile(c0572k.f6318a, new String[]{uri != null ? uri.getPath() : ""}, null, new MediaScannerConnection.OnScanCompletedListener() { // from class: o4.d
                                    @Override // android.media.MediaScannerConnection.OnScanCompletedListener
                                    public final void onScanCompleted(String str, Uri uri22) {
                                        o oVar;
                                        c cVar22 = cVar;
                                        int i102 = cVar22.f8681a;
                                        f fVar22 = cVar22.f8682b;
                                        switch (i102) {
                                            case 0:
                                                synchronized (fVar22.f8696p) {
                                                    f.d dVar = fVar22.f8695o;
                                                    oVar = dVar != null ? (o) dVar.f6383c : null;
                                                    break;
                                                }
                                                if (oVar == null) {
                                                    fVar22.d(str);
                                                    return;
                                                }
                                                String strS = fVar22.f8688c.s(str, oVar.f8716a, oVar.f8717b, oVar.f8718c.intValue());
                                                if (strS != null && !strS.equals(str)) {
                                                    new File(str).delete();
                                                }
                                                fVar22.d(strS);
                                                return;
                                            default:
                                                fVar22.d(str);
                                                return;
                                        }
                                    }
                                });
                            }
                            break;
                        default:
                            int i102 = i6;
                            f fVar2 = this.f8679b;
                            if (i102 != -1) {
                                fVar2.d(null);
                            } else {
                                Uri uri2 = fVar2.f8694n;
                                if (uri2 == null) {
                                    uri2 = Uri.parse(((Activity) fVar2.f8689d.f3665b).getSharedPreferences("flutter_image_picker_shared_preference", 0).getString("flutter_image_picker_pending_image_uri", ""));
                                }
                                final c cVar2 = new c(fVar2, 1);
                                C0572k c0572k2 = fVar2.f8690f;
                                c0572k2.getClass();
                                MediaScannerConnection.scanFile(c0572k2.f6318a, new String[]{uri2 != null ? uri2.getPath() : ""}, null, new MediaScannerConnection.OnScanCompletedListener() { // from class: o4.d
                                    @Override // android.media.MediaScannerConnection.OnScanCompletedListener
                                    public final void onScanCompleted(String str, Uri uri22) {
                                        o oVar;
                                        c cVar22 = cVar2;
                                        int i1022 = cVar22.f8681a;
                                        f fVar22 = cVar22.f8682b;
                                        switch (i1022) {
                                            case 0:
                                                synchronized (fVar22.f8696p) {
                                                    f.d dVar = fVar22.f8695o;
                                                    oVar = dVar != null ? (o) dVar.f6383c : null;
                                                    break;
                                                }
                                                if (oVar == null) {
                                                    fVar22.d(str);
                                                    return;
                                                }
                                                String strS = fVar22.f8688c.s(str, oVar.f8716a, oVar.f8717b, oVar.f8718c.intValue());
                                                if (strS != null && !strS.equals(str)) {
                                                    new File(str).delete();
                                                }
                                                fVar22.d(strS);
                                                return;
                                            default:
                                                fVar22.d(str);
                                                return;
                                        }
                                    }
                                });
                            }
                            break;
                    }
                }
            };
        }
        this.f8692l.execute(runnable);
        return true;
    }

    @Override // Z3.u
    public final boolean onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        boolean z6 = iArr.length > 0 && iArr[0] == 0;
        if (i != 2345) {
            if (i != 2355) {
                return false;
            }
            if (z6) {
                i();
            }
        } else if (z6) {
            h();
        }
        if (!z6 && (i == 2345 || i == 2355)) {
            b("camera_access_denied", "The user did not allow camera access.");
        }
        return true;
    }
}
