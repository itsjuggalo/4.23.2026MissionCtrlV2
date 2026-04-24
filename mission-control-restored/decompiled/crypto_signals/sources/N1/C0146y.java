package N1;

import a1.InterfaceC0286b;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.text.TextUtils;
import android.util.Log;
import androidx.preference.EditTextPreference;
import androidx.preference.Preference;
import com.cryptosignals.ap.android.R;
import com.google.android.gms.common.api.internal.InterfaceC0417u;
import com.google.android.gms.internal.measurement.zzpc;
import com.google.android.gms.internal.measurement.zzpl;
import com.google.android.gms.internal.measurement.zzpr;
import com.google.android.gms.internal.measurement.zzqd;
import com.google.android.gms.internal.measurement.zzqp;
import com.google.android.gms.internal.measurement.zzqv;
import com.google.android.gms.internal.measurement.zzre;
import com.google.android.gms.internal.measurement.zzrh;
import com.google.android.gms.internal.measurement.zzrn;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import e1.C0529b;
import e1.C0530c;
import i0.InterfaceC0645a;
import i2.C0664j;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Executors;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/* JADX INFO: renamed from: N1.y, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class C0146y implements InterfaceC0137v, P2.y, InterfaceC0286b, Z3.o, InterfaceC0417u, InterfaceC0645a, Continuation, l.o, n0.c {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ C0146y f1855b = new C0146y(0);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ C0146y f1856c = new C0146y(1);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ C0146y f1857d = new C0146y(2);
    public static final /* synthetic */ C0146y e = new C0146y(3);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ C0146y f1858f = new C0146y(4);

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final /* synthetic */ C0146y f1859k = new C0146y(5);

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final /* synthetic */ C0146y f1860l = new C0146y(6);

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final /* synthetic */ C0146y f1861m = new C0146y(7);

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final /* synthetic */ C0146y f1862n = new C0146y(8);

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final /* synthetic */ C0146y f1863o = new C0146y(9);

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final /* synthetic */ C0146y f1864p = new C0146y(10);

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final /* synthetic */ C0146y f1865q = new C0146y(11);

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final /* synthetic */ C0146y f1866r = new C0146y(12);

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static C0146y f1867s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static C0146y f1868t;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1869a;

    public /* synthetic */ C0146y(int i) {
        this.f1869a = i;
    }

    public static void d(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
            }
        }
    }

    public static void e(X.h hVar, X.h hVar2) {
        for (String str : Arrays.asList("ImageDescription", "Make", "Model", "Software", "DateTime", "Artist", "Copyright", "ExposureTime", "FNumber", "ExposureProgram", "SpectralSensitivity", "PhotographicSensitivity", "ISOSpeedRatings", "OECF", "SensitivityType", "StandardOutputSensitivity", "RecommendedExposureIndex", "ISOSpeed", "ISOSpeedLatitudeyyy", "ISOSpeedLatitudezzz", "ExifVersion", "DateTimeOriginal", "DateTimeDigitized", "OffsetTime", "OffsetTimeOriginal", "OffsetTimeDigitized", "ShutterSpeedValue", "ApertureValue", "BrightnessValue", "ExposureBiasValue", "MaxApertureValue", "SubjectDistance", "MeteringMode", "LightSource", "Flash", "FocalLength", "MakerNote", "UserComment", "SubSecTime", "SubSecTimeOriginal", "SubSecTimeDigitized", "FlashpixVersion", "FlashEnergy", "SpatialFrequencyResponse", "FocalPlaneXResolution", "FocalPlaneYResolution", "FocalPlaneResolutionUnit", "ExposureIndex", "SensingMethod", "FileSource", "SceneType", "CFAPattern", "CustomRendered", "ExposureMode", "WhiteBalance", "DigitalZoomRatio", "FocalLengthIn35mmFilm", "SceneCaptureType", "GainControl", "Contrast", "Saturation", "Sharpness", "DeviceSettingDescription", "SubjectDistanceRange", "ImageUniqueID", "CameraOwnerName", "BodySerialNumber", "LensSpecification", "LensMake", "LensModel", "LensSerialNumber", "GPSVersionID", "GPSLatitudeRef", "GPSLatitude", "GPSLongitudeRef", "GPSLongitude", "GPSAltitudeRef", "GPSAltitude", "GPSTimeStamp", "GPSSatellites", "GPSStatus", "GPSMeasureMode", "GPSDOP", "GPSSpeedRef", "GPSSpeed", "GPSTrackRef", "GPSTrack", "GPSImgDirectionRef", "GPSImgDirection", "GPSMapDatum", "GPSDestLatitudeRef", "GPSDestLatitude", "GPSDestLongitudeRef", "GPSDestLongitude", "GPSDestBearingRef", "GPSDestBearing", "GPSDestDistanceRef", "GPSDestDistance", "GPSProcessingMethod", "GPSAreaInformation", "GPSDateStamp", "GPSDifferential", "GPSHPositioningError", "InteroperabilityIndex", "Orientation")) {
            if (hVar.b(str) != null) {
                hVar2.D(str, hVar.b(str));
            }
        }
        hVar2.z();
    }

    public static A.c f(Context context, String[] strArr, String str, e3.w wVar) {
        String[] strArrJ = j(context);
        int length = strArrJ.length;
        int i = 0;
        while (true) {
            ZipFile zipFile = null;
            if (i >= length) {
                return null;
            }
            String str2 = strArrJ[i];
            int i6 = 0;
            while (true) {
                int i7 = i6 + 1;
                if (i6 >= 5) {
                    break;
                }
                try {
                    zipFile = new ZipFile(new File(str2), 1);
                    break;
                } catch (IOException unused) {
                    i6 = i7;
                }
            }
            if (zipFile != null) {
                int i8 = 0;
                while (true) {
                    int i9 = i8 + 1;
                    if (i8 < 5) {
                        for (String str3 : strArr) {
                            StringBuilder sb = new StringBuilder("lib");
                            char c6 = File.separatorChar;
                            sb.append(c6);
                            sb.append(str3);
                            sb.append(c6);
                            sb.append(str);
                            String string = sb.toString();
                            wVar.y("Looking for %s in APK %s...", string, str2);
                            ZipEntry entry = zipFile.getEntry(string);
                            if (entry != null) {
                                A.c cVar = new A.c(25, false);
                                cVar.f7b = zipFile;
                                cVar.f8c = entry;
                                return cVar;
                            }
                        }
                        i8 = i9;
                    } else {
                        try {
                            zipFile.close();
                            break;
                        } catch (IOException unused2) {
                        }
                    }
                }
            }
            i++;
        }
    }

    public static String[] i(Context context, String str) {
        StringBuilder sb = new StringBuilder("lib");
        char c6 = File.separatorChar;
        sb.append(c6);
        sb.append("([^\\");
        sb.append(c6);
        sb.append("]*)");
        sb.append(c6);
        sb.append(str);
        Pattern patternCompile = Pattern.compile(sb.toString());
        HashSet hashSet = new HashSet();
        for (String str2 : j(context)) {
            try {
                Enumeration<? extends ZipEntry> enumerationEntries = new ZipFile(new File(str2), 1).entries();
                while (enumerationEntries.hasMoreElements()) {
                    Matcher matcher = patternCompile.matcher(enumerationEntries.nextElement().getName());
                    if (matcher.matches()) {
                        hashSet.add(matcher.group(1));
                    }
                }
            } catch (IOException unused) {
            }
        }
        return (String[]) hashSet.toArray(new String[hashSet.size()]);
    }

    public static String[] j(Context context) {
        ApplicationInfo applicationInfo = context.getApplicationInfo();
        String[] strArr = applicationInfo.splitSourceDirs;
        if (strArr == null || strArr.length == 0) {
            return new String[]{applicationInfo.sourceDir};
        }
        String[] strArr2 = new String[strArr.length + 1];
        strArr2[0] = applicationInfo.sourceDir;
        System.arraycopy(strArr, 0, strArr2, 1, strArr.length);
        return strArr2;
    }

    @Override // n0.c
    public void b(int i, Serializable serializable) {
        String str;
        switch (i) {
            case 1:
                str = "RESULT_INSTALL_SUCCESS";
                break;
            case 2:
                str = "RESULT_ALREADY_INSTALLED";
                break;
            case 3:
                str = "RESULT_UNSUPPORTED_ART_VERSION";
                break;
            case 4:
                str = "RESULT_NOT_WRITABLE";
                break;
            case 5:
                str = "RESULT_DESIRED_FORMAT_UNSUPPORTED";
                break;
            case 6:
                str = "RESULT_BASELINE_PROFILE_NOT_FOUND";
                break;
            case 7:
                str = "RESULT_IO_EXCEPTION";
                break;
            case 8:
                str = "RESULT_PARSE_EXCEPTION";
                break;
            case s3.I0.ARRAY_VALUE_FIELD_NUMBER /* 9 */:
            default:
                str = "";
                break;
            case s3.I0.TIMESTAMP_VALUE_FIELD_NUMBER /* 10 */:
                str = "RESULT_INSTALL_SKIP_FILE_SUCCESS";
                break;
            case 11:
                str = "RESULT_DELETE_SKIP_FILE_SUCCESS";
                break;
        }
        if (i == 6 || i == 7 || i == 8) {
            Log.e("ProfileInstaller", str, (Throwable) serializable);
        } else {
            Log.d("ProfileInstaller", str);
        }
    }

    @Override // i0.InterfaceC0645a
    public CharSequence c(Preference preference) {
        EditTextPreference editTextPreference = (EditTextPreference) preference;
        editTextPreference.getClass();
        if (TextUtils.isEmpty(null)) {
            return editTextPreference.f4714a.getString(R.string.not_set);
        }
        return null;
    }

    @Override // l.o
    public boolean g(l.i iVar) {
        return false;
    }

    @Override // F4.a
    public Object get() {
        switch (this.f1869a) {
            case s3.I0.BYTES_VALUE_FIELD_NUMBER /* 18 */:
                return new P0(Executors.newSingleThreadExecutor(), 1);
            default:
                A a6 = new A(23);
                HashMap map = new HashMap();
                V0.d dVar = V0.d.f3186a;
                Set set = Collections.EMPTY_SET;
                if (set == null) {
                    throw new NullPointerException("Null flags");
                }
                map.put(dVar, new C0530c(30000L, 86400000L, set));
                V0.d dVar2 = V0.d.f3188c;
                if (set == null) {
                    throw new NullPointerException("Null flags");
                }
                map.put(dVar2, new C0530c(1000L, 86400000L, set));
                V0.d dVar3 = V0.d.f3187b;
                if (set == null) {
                    throw new NullPointerException("Null flags");
                }
                Set setUnmodifiableSet = Collections.unmodifiableSet(new HashSet(Arrays.asList(e1.e.f6052b)));
                if (setUnmodifiableSet == null) {
                    throw new NullPointerException("Null flags");
                }
                map.put(dVar3, new C0530c(86400000L, 86400000L, setUnmodifiableSet));
                if (map.keySet().size() < V0.d.values().length) {
                    throw new IllegalStateException("Not all priorities have been configured");
                }
                new HashMap();
                return new C0529b(a6, map);
        }
    }

    @Override // n0.c
    public void h() {
        Log.d("ProfileInstaller", "DIAGNOSTIC_PROFILE_IS_COMPRESSED");
    }

    @Override // Z3.o
    public void onMethodCall(Z3.n nVar, Z3.p pVar) {
        ((Y3.h) pVar).c(null);
    }

    @Override // com.google.android.gms.tasks.Continuation
    public Object then(Task task) {
        return (!task.isSuccessful() && (task.getException() instanceof C0664j) && ((C0664j) task.getException()).f6796a.equals("ERROR_INTERNAL_SUCCESS_SIGN_OUT")) ? Tasks.forResult(null) : task;
    }

    @Override // N1.InterfaceC0137v
    public /* synthetic */ Object zza() {
        switch (this.f1869a) {
            case 0:
                List list = E.f1180a;
                return Integer.valueOf((int) zzpc.zzW());
            case 1:
                List list2 = E.f1180a;
                return Integer.valueOf((int) zzpc.zzv());
            case 2:
                List list3 = E.f1180a;
                return Integer.valueOf((int) zzpc.zzB());
            case 3:
                List list4 = E.f1180a;
                return Integer.valueOf((int) zzpc.zzai());
            case 4:
                List list5 = E.f1180a;
                return Boolean.valueOf(zzrn.zzb());
            case 5:
                List list6 = E.f1180a;
                return Boolean.valueOf(zzpr.zzb());
            case 6:
                List list7 = E.f1180a;
                return Boolean.valueOf(zzrh.zza());
            case 7:
                List list8 = E.f1180a;
                return Boolean.valueOf(zzqp.zzb());
            case 8:
                List list9 = E.f1180a;
                return Boolean.valueOf(zzqp.zzc());
            case s3.I0.ARRAY_VALUE_FIELD_NUMBER /* 9 */:
                List list10 = E.f1180a;
                return Boolean.valueOf(zzpl.zza());
            case s3.I0.TIMESTAMP_VALUE_FIELD_NUMBER /* 10 */:
                List list11 = E.f1180a;
                return Boolean.valueOf(zzqv.zza());
            case 11:
                return new Boolean(zzqd.zza());
            default:
                return new Boolean(zzre.zza());
        }
    }

    @Override // P2.y
    public void run() {
    }

    @Override // l.o
    public void a(l.i iVar, boolean z6) {
    }
}
