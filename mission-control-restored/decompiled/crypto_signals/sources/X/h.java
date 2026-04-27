package X;

import android.content.res.AssetManager;
import android.media.MediaMetadataRetriever;
import android.os.Build;
import android.system.OsConstants;
import android.util.Log;
import android.util.Pair;
import j$.util.DesugarTimeZone;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.EOFException;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.regex.Pattern;
import java.util.zip.CRC32;
import s3.D;

/* JADX INFO: loaded from: classes.dex */
public final class h {

    /* JADX INFO: renamed from: U, reason: collision with root package name */
    public static final e f3388U;

    /* JADX INFO: renamed from: V, reason: collision with root package name */
    public static final e[][] f3389V;

    /* JADX INFO: renamed from: W, reason: collision with root package name */
    public static final e[] f3390W;

    /* JADX INFO: renamed from: X, reason: collision with root package name */
    public static final HashMap[] f3391X;

    /* JADX INFO: renamed from: Y, reason: collision with root package name */
    public static final HashMap[] f3392Y;

    /* JADX INFO: renamed from: Z, reason: collision with root package name */
    public static final HashSet f3393Z;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    public static final HashMap f3394a0;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    public static final Charset f3395b0;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    public static final byte[] f3396c0;

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    public static final byte[] f3397d0;

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    public static final Pattern f3398e0;

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    public static final Pattern f3399f0;

    /* JADX INFO: renamed from: g0, reason: collision with root package name */
    public static final Pattern f3400g0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f3407a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final FileDescriptor f3408b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AssetManager.AssetInputStream f3409c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f3410d;
    public final HashMap[] e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final HashSet f3411f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public ByteOrder f3412g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f3413h;
    public boolean i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f3414j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f3415k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f3416l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public byte[] f3417m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f3418n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f3419o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f3420p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f3421q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f3422r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f3423s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final boolean f3401t = Log.isLoggable("ExifInterface", 3);

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final List f3402u = Arrays.asList(1, 6, 3, 8);

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final List f3403v = Arrays.asList(2, 7, 4, 5);

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final int[] f3404w = {8, 8, 8};

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final int[] f3405x = {8};
    public static final byte[] y = {-1, -40, -1};

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final byte[] f3406z = {102, 116, 121, 112};

    /* JADX INFO: renamed from: A, reason: collision with root package name */
    public static final byte[] f3370A = {109, 105, 102, 49};

    /* JADX INFO: renamed from: B, reason: collision with root package name */
    public static final byte[] f3371B = {104, 101, 105, 99};

    /* JADX INFO: renamed from: C, reason: collision with root package name */
    public static final byte[] f3372C = {79, 76, 89, 77, 80, 0};

    /* JADX INFO: renamed from: D, reason: collision with root package name */
    public static final byte[] f3373D = {79, 76, 89, 77, 80, 85, 83, 0, 73, 73};

    /* JADX INFO: renamed from: E, reason: collision with root package name */
    public static final byte[] f3374E = {-119, 80, 78, 71, 13, 10, 26, 10};

    /* JADX INFO: renamed from: F, reason: collision with root package name */
    public static final byte[] f3375F = {101, 88, 73, 102};

    /* JADX INFO: renamed from: G, reason: collision with root package name */
    public static final byte[] f3376G = {73, 72, 68, 82};

    /* JADX INFO: renamed from: H, reason: collision with root package name */
    public static final byte[] f3377H = {73, 69, 78, 68};

    /* JADX INFO: renamed from: I, reason: collision with root package name */
    public static final byte[] f3378I = {82, 73, 70, 70};

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public static final byte[] f3379J = {87, 69, 66, 80};

    /* JADX INFO: renamed from: K, reason: collision with root package name */
    public static final byte[] f3380K = {69, 88, 73, 70};

    /* JADX INFO: renamed from: L, reason: collision with root package name */
    public static final byte[] f3381L = {-99, 1, 42};

    /* JADX INFO: renamed from: M, reason: collision with root package name */
    public static final byte[] f3382M = "VP8X".getBytes(Charset.defaultCharset());
    public static final byte[] N = "VP8L".getBytes(Charset.defaultCharset());

    /* JADX INFO: renamed from: O, reason: collision with root package name */
    public static final byte[] f3383O = "VP8 ".getBytes(Charset.defaultCharset());
    public static final byte[] P = "ANIM".getBytes(Charset.defaultCharset());

    /* JADX INFO: renamed from: Q, reason: collision with root package name */
    public static final byte[] f3384Q = "ANMF".getBytes(Charset.defaultCharset());

    /* JADX INFO: renamed from: R, reason: collision with root package name */
    public static final String[] f3385R = {"", "BYTE", "STRING", "USHORT", "ULONG", "URATIONAL", "SBYTE", "UNDEFINED", "SSHORT", "SLONG", "SRATIONAL", "SINGLE", "DOUBLE", "IFD"};

    /* JADX INFO: renamed from: S, reason: collision with root package name */
    public static final int[] f3386S = {0, 1, 1, 2, 4, 8, 1, 1, 2, 4, 8, 4, 8, 1};

    /* JADX INFO: renamed from: T, reason: collision with root package name */
    public static final byte[] f3387T = {65, 83, 67, 73, 73, 0, 0, 0};

    static {
        e[] eVarArr = {new e("NewSubfileType", 254, 4), new e("SubfileType", 255, 4), new e(256, 3, 4, "ImageWidth"), new e(257, 3, 4, "ImageLength"), new e("BitsPerSample", 258, 3), new e("Compression", 259, 3), new e("PhotometricInterpretation", 262, 3), new e("ImageDescription", 270, 2), new e("Make", 271, 2), new e("Model", 272, 2), new e(273, 3, 4, "StripOffsets"), new e("Orientation", 274, 3), new e("SamplesPerPixel", 277, 3), new e(278, 3, 4, "RowsPerStrip"), new e(279, 3, 4, "StripByteCounts"), new e("XResolution", 282, 5), new e("YResolution", 283, 5), new e("PlanarConfiguration", 284, 3), new e("ResolutionUnit", 296, 3), new e("TransferFunction", 301, 3), new e("Software", 305, 2), new e("DateTime", 306, 2), new e("Artist", 315, 2), new e("WhitePoint", 318, 5), new e("PrimaryChromaticities", 319, 5), new e("SubIFDPointer", 330, 4), new e("JPEGInterchangeFormat", 513, 4), new e("JPEGInterchangeFormatLength", 514, 4), new e("YCbCrCoefficients", 529, 5), new e("YCbCrSubSampling", 530, 3), new e("YCbCrPositioning", 531, 3), new e("ReferenceBlackWhite", 532, 5), new e("Copyright", 33432, 2), new e("ExifIFDPointer", 34665, 4), new e("GPSInfoIFDPointer", 34853, 4), new e("SensorTopBorder", 4, 4), new e("SensorLeftBorder", 5, 4), new e("SensorBottomBorder", 6, 4), new e("SensorRightBorder", 7, 4), new e("ISO", 23, 3), new e("JpgFromRaw", 46, 7), new e("Xmp", 700, 1)};
        e[] eVarArr2 = {new e("ExposureTime", 33434, 5), new e("FNumber", 33437, 5), new e("ExposureProgram", 34850, 3), new e("SpectralSensitivity", 34852, 2), new e("PhotographicSensitivity", 34855, 3), new e("OECF", 34856, 7), new e("SensitivityType", 34864, 3), new e("StandardOutputSensitivity", 34865, 4), new e("RecommendedExposureIndex", 34866, 4), new e("ISOSpeed", 34867, 4), new e("ISOSpeedLatitudeyyy", 34868, 4), new e("ISOSpeedLatitudezzz", 34869, 4), new e("ExifVersion", 36864, 2), new e("DateTimeOriginal", 36867, 2), new e("DateTimeDigitized", 36868, 2), new e("OffsetTime", 36880, 2), new e("OffsetTimeOriginal", 36881, 2), new e("OffsetTimeDigitized", 36882, 2), new e("ComponentsConfiguration", 37121, 7), new e("CompressedBitsPerPixel", 37122, 5), new e("ShutterSpeedValue", 37377, 10), new e("ApertureValue", 37378, 5), new e("BrightnessValue", 37379, 10), new e("ExposureBiasValue", 37380, 10), new e("MaxApertureValue", 37381, 5), new e("SubjectDistance", 37382, 5), new e("MeteringMode", 37383, 3), new e("LightSource", 37384, 3), new e("Flash", 37385, 3), new e("FocalLength", 37386, 5), new e("SubjectArea", 37396, 3), new e("MakerNote", 37500, 7), new e("UserComment", 37510, 7), new e("SubSecTime", 37520, 2), new e("SubSecTimeOriginal", 37521, 2), new e("SubSecTimeDigitized", 37522, 2), new e("FlashpixVersion", 40960, 7), new e("ColorSpace", 40961, 3), new e(40962, 3, 4, "PixelXDimension"), new e(40963, 3, 4, "PixelYDimension"), new e("RelatedSoundFile", 40964, 2), new e("InteroperabilityIFDPointer", 40965, 4), new e("FlashEnergy", 41483, 5), new e("SpatialFrequencyResponse", 41484, 7), new e("FocalPlaneXResolution", 41486, 5), new e("FocalPlaneYResolution", 41487, 5), new e("FocalPlaneResolutionUnit", 41488, 3), new e("SubjectLocation", 41492, 3), new e("ExposureIndex", 41493, 5), new e("SensingMethod", 41495, 3), new e("FileSource", 41728, 7), new e("SceneType", 41729, 7), new e("CFAPattern", 41730, 7), new e("CustomRendered", 41985, 3), new e("ExposureMode", 41986, 3), new e("WhiteBalance", 41987, 3), new e("DigitalZoomRatio", 41988, 5), new e("FocalLengthIn35mmFilm", 41989, 3), new e("SceneCaptureType", 41990, 3), new e("GainControl", 41991, 3), new e("Contrast", 41992, 3), new e("Saturation", 41993, 3), new e("Sharpness", 41994, 3), new e("DeviceSettingDescription", 41995, 7), new e("SubjectDistanceRange", 41996, 3), new e("ImageUniqueID", 42016, 2), new e("CameraOwnerName", 42032, 2), new e("BodySerialNumber", 42033, 2), new e("LensSpecification", 42034, 5), new e("LensMake", 42035, 2), new e("LensModel", 42036, 2), new e("Gamma", 42240, 5), new e("DNGVersion", 50706, 1), new e(50720, 3, 4, "DefaultCropSize")};
        e[] eVarArr3 = {new e("GPSVersionID", 0, 1), new e("GPSLatitudeRef", 1, 2), new e(2, 5, 10, "GPSLatitude"), new e("GPSLongitudeRef", 3, 2), new e(4, 5, 10, "GPSLongitude"), new e("GPSAltitudeRef", 5, 1), new e("GPSAltitude", 6, 5), new e("GPSTimeStamp", 7, 5), new e("GPSSatellites", 8, 2), new e("GPSStatus", 9, 2), new e("GPSMeasureMode", 10, 2), new e("GPSDOP", 11, 5), new e("GPSSpeedRef", 12, 2), new e("GPSSpeed", 13, 5), new e("GPSTrackRef", 14, 2), new e("GPSTrack", 15, 5), new e("GPSImgDirectionRef", 16, 2), new e("GPSImgDirection", 17, 5), new e("GPSMapDatum", 18, 2), new e("GPSDestLatitudeRef", 19, 2), new e("GPSDestLatitude", 20, 5), new e("GPSDestLongitudeRef", 21, 2), new e("GPSDestLongitude", 22, 5), new e("GPSDestBearingRef", 23, 2), new e("GPSDestBearing", 24, 5), new e("GPSDestDistanceRef", 25, 2), new e("GPSDestDistance", 26, 5), new e("GPSProcessingMethod", 27, 7), new e("GPSAreaInformation", 28, 7), new e("GPSDateStamp", 29, 2), new e("GPSDifferential", 30, 3), new e("GPSHPositioningError", 31, 5)};
        e[] eVarArr4 = {new e("InteroperabilityIndex", 1, 2)};
        e[] eVarArr5 = {new e("NewSubfileType", 254, 4), new e("SubfileType", 255, 4), new e(256, 3, 4, "ThumbnailImageWidth"), new e(257, 3, 4, "ThumbnailImageLength"), new e("BitsPerSample", 258, 3), new e("Compression", 259, 3), new e("PhotometricInterpretation", 262, 3), new e("ImageDescription", 270, 2), new e("Make", 271, 2), new e("Model", 272, 2), new e(273, 3, 4, "StripOffsets"), new e("ThumbnailOrientation", 274, 3), new e("SamplesPerPixel", 277, 3), new e(278, 3, 4, "RowsPerStrip"), new e(279, 3, 4, "StripByteCounts"), new e("XResolution", 282, 5), new e("YResolution", 283, 5), new e("PlanarConfiguration", 284, 3), new e("ResolutionUnit", 296, 3), new e("TransferFunction", 301, 3), new e("Software", 305, 2), new e("DateTime", 306, 2), new e("Artist", 315, 2), new e("WhitePoint", 318, 5), new e("PrimaryChromaticities", 319, 5), new e("SubIFDPointer", 330, 4), new e("JPEGInterchangeFormat", 513, 4), new e("JPEGInterchangeFormatLength", 514, 4), new e("YCbCrCoefficients", 529, 5), new e("YCbCrSubSampling", 530, 3), new e("YCbCrPositioning", 531, 3), new e("ReferenceBlackWhite", 532, 5), new e("Copyright", 33432, 2), new e("ExifIFDPointer", 34665, 4), new e("GPSInfoIFDPointer", 34853, 4), new e("DNGVersion", 50706, 1), new e(50720, 3, 4, "DefaultCropSize")};
        f3388U = new e("StripOffsets", 273, 3);
        f3389V = new e[][]{eVarArr, eVarArr2, eVarArr3, eVarArr4, eVarArr5, eVarArr, new e[]{new e("ThumbnailImage", 256, 7), new e("CameraSettingsIFDPointer", 8224, 4), new e("ImageProcessingIFDPointer", 8256, 4)}, new e[]{new e("PreviewImageStart", 257, 4), new e("PreviewImageLength", 258, 4)}, new e[]{new e("AspectFrame", 4371, 3)}, new e[]{new e("ColorSpace", 55, 3)}};
        f3390W = new e[]{new e("SubIFDPointer", 330, 4), new e("ExifIFDPointer", 34665, 4), new e("GPSInfoIFDPointer", 34853, 4), new e("InteroperabilityIFDPointer", 40965, 4), new e("CameraSettingsIFDPointer", 8224, 1), new e("ImageProcessingIFDPointer", 8256, 1)};
        f3391X = new HashMap[10];
        f3392Y = new HashMap[10];
        f3393Z = new HashSet(Arrays.asList("FNumber", "DigitalZoomRatio", "ExposureTime", "SubjectDistance", "GPSTimeStamp"));
        f3394a0 = new HashMap();
        Charset charsetForName = Charset.forName("US-ASCII");
        f3395b0 = charsetForName;
        f3396c0 = "Exif\u0000\u0000".getBytes(charsetForName);
        f3397d0 = "http://ns.adobe.com/xap/1.0/\u0000".getBytes(charsetForName);
        Locale locale = Locale.US;
        new SimpleDateFormat("yyyy:MM:dd HH:mm:ss", locale).setTimeZone(DesugarTimeZone.getTimeZone("UTC"));
        new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", locale).setTimeZone(DesugarTimeZone.getTimeZone("UTC"));
        int i = 0;
        while (true) {
            e[][] eVarArr6 = f3389V;
            if (i >= eVarArr6.length) {
                HashMap map = f3394a0;
                e[] eVarArr7 = f3390W;
                map.put(Integer.valueOf(eVarArr7[0].f3364a), 5);
                map.put(Integer.valueOf(eVarArr7[1].f3364a), 1);
                map.put(Integer.valueOf(eVarArr7[2].f3364a), 2);
                map.put(Integer.valueOf(eVarArr7[3].f3364a), 3);
                map.put(Integer.valueOf(eVarArr7[4].f3364a), 7);
                map.put(Integer.valueOf(eVarArr7[5].f3364a), 8);
                Pattern.compile(".*[1-9].*");
                f3398e0 = Pattern.compile("^(\\d{2}):(\\d{2}):(\\d{2})$");
                f3399f0 = Pattern.compile("^(\\d{4}):(\\d{2}):(\\d{2})\\s(\\d{2}):(\\d{2}):(\\d{2})$");
                f3400g0 = Pattern.compile("^(\\d{4})-(\\d{2})-(\\d{2})\\s(\\d{2}):(\\d{2}):(\\d{2})$");
                return;
            }
            f3391X[i] = new HashMap();
            f3392Y[i] = new HashMap();
            for (e eVar : eVarArr6[i]) {
                f3391X[i].put(Integer.valueOf(eVar.f3364a), eVar);
                f3392Y[i].put(eVar.f3365b, eVar);
            }
            i++;
        }
    }

    public h(String str) throws Throwable {
        FileInputStream fileInputStream;
        boolean z6;
        e[][] eVarArr = f3389V;
        this.e = new HashMap[eVarArr.length];
        this.f3411f = new HashSet(eVarArr.length);
        this.f3412g = ByteOrder.BIG_ENDIAN;
        if (str == null) {
            throw new NullPointerException("filename cannot be null");
        }
        FileInputStream fileInputStream2 = null;
        this.f3409c = null;
        this.f3407a = str;
        try {
            fileInputStream = new FileInputStream(str);
        } catch (Throwable th) {
            th = th;
        }
        try {
            try {
                i.c(fileInputStream.getFD(), 0L, OsConstants.SEEK_CUR);
                z6 = true;
            } catch (Exception unused) {
                if (f3401t) {
                    Log.d("ExifInterface", "The file descriptor for the given input is not seekable");
                }
                z6 = false;
            }
            if (z6) {
                this.f3408b = fileInputStream.getFD();
            } else {
                this.f3408b = null;
            }
            r(fileInputStream);
            D.q(fileInputStream);
        } catch (Throwable th2) {
            th = th2;
            fileInputStream2 = fileInputStream;
            D.q(fileInputStream2);
            throw th;
        }
    }

    public static Pair o(String str) {
        if (str.contains(",")) {
            String[] strArrSplit = str.split(",", -1);
            Pair pairO = o(strArrSplit[0]);
            if (((Integer) pairO.first).intValue() == 2) {
                return pairO;
            }
            for (int i = 1; i < strArrSplit.length; i++) {
                Pair pairO2 = o(strArrSplit[i]);
                int iIntValue = (((Integer) pairO2.first).equals(pairO.first) || ((Integer) pairO2.second).equals(pairO.first)) ? ((Integer) pairO.first).intValue() : -1;
                int iIntValue2 = (((Integer) pairO.second).intValue() == -1 || !(((Integer) pairO2.first).equals(pairO.second) || ((Integer) pairO2.second).equals(pairO.second))) ? -1 : ((Integer) pairO.second).intValue();
                if (iIntValue == -1 && iIntValue2 == -1) {
                    return new Pair(2, -1);
                }
                if (iIntValue == -1) {
                    pairO = new Pair(Integer.valueOf(iIntValue2), -1);
                } else if (iIntValue2 == -1) {
                    pairO = new Pair(Integer.valueOf(iIntValue), -1);
                }
            }
            return pairO;
        }
        if (!str.contains("/")) {
            try {
                try {
                    long j4 = Long.parseLong(str);
                    return (j4 < 0 || j4 > 65535) ? j4 < 0 ? new Pair(9, -1) : new Pair(4, -1) : new Pair(3, 4);
                } catch (NumberFormatException unused) {
                    return new Pair(2, -1);
                }
            } catch (NumberFormatException unused2) {
                Double.parseDouble(str);
                return new Pair(12, -1);
            }
        }
        String[] strArrSplit2 = str.split("/", -1);
        if (strArrSplit2.length == 2) {
            try {
                long j6 = (long) Double.parseDouble(strArrSplit2[0]);
                long j7 = (long) Double.parseDouble(strArrSplit2[1]);
                if (j6 >= 0 && j7 >= 0) {
                    if (j6 <= 2147483647L && j7 <= 2147483647L) {
                        return new Pair(10, 5);
                    }
                    return new Pair(5, -1);
                }
                return new Pair(10, -1);
            } catch (NumberFormatException unused3) {
            }
        }
        return new Pair(2, -1);
    }

    public static ByteOrder u(b bVar) throws IOException {
        short s6 = bVar.readShort();
        boolean z6 = f3401t;
        if (s6 == 18761) {
            if (z6) {
                Log.d("ExifInterface", "readExifSegment: Byte Align II");
            }
            return ByteOrder.LITTLE_ENDIAN;
        }
        if (s6 == 19789) {
            if (z6) {
                Log.d("ExifInterface", "readExifSegment: Byte Align MM");
            }
            return ByteOrder.BIG_ENDIAN;
        }
        throw new IOException("Invalid byte order: " + Integer.toHexString(s6));
    }

    public final void A(BufferedInputStream bufferedInputStream, BufferedOutputStream bufferedOutputStream) throws IOException {
        if (f3401t) {
            Log.d("ExifInterface", "saveJpegAttributes starting with (inputStream: " + bufferedInputStream + ", outputStream: " + bufferedOutputStream + ")");
        }
        b bVar = new b(bufferedInputStream);
        c cVar = new c(bufferedOutputStream, ByteOrder.BIG_ENDIAN);
        if (bVar.readByte() != -1) {
            throw new IOException("Invalid marker");
        }
        cVar.d(-1);
        if (bVar.readByte() != -40) {
            throw new IOException("Invalid marker");
        }
        cVar.d(-40);
        String strB = b("Xmp");
        HashMap[] mapArr = this.e;
        d dVar = (strB == null || !this.f3423s) ? null : (d) mapArr[0].remove("Xmp");
        cVar.d(-1);
        cVar.d(-31);
        I(cVar);
        if (dVar != null) {
            mapArr[0].put("Xmp", dVar);
        }
        byte[] bArr = new byte[4096];
        while (bVar.readByte() == -1) {
            byte b3 = bVar.readByte();
            if (b3 == -39 || b3 == -38) {
                cVar.d(-1);
                cVar.d(b3);
                D.t(bVar, cVar);
                return;
            }
            if (b3 != -31) {
                cVar.d(-1);
                cVar.d(b3);
                int unsignedShort = bVar.readUnsignedShort();
                cVar.i(unsignedShort);
                int i = unsignedShort - 2;
                if (i < 0) {
                    throw new IOException("Invalid length");
                }
                while (i > 0) {
                    int i6 = bVar.read(bArr, 0, Math.min(i, 4096));
                    if (i6 >= 0) {
                        cVar.write(bArr, 0, i6);
                        i -= i6;
                    }
                }
            } else {
                int unsignedShort2 = bVar.readUnsignedShort();
                int i7 = unsignedShort2 - 2;
                if (i7 < 0) {
                    throw new IOException("Invalid length");
                }
                byte[] bArr2 = new byte[6];
                if (i7 >= 6) {
                    bVar.readFully(bArr2);
                    if (Arrays.equals(bArr2, f3396c0)) {
                        bVar.d(unsignedShort2 - 8);
                    }
                }
                cVar.d(-1);
                cVar.d(b3);
                cVar.i(unsignedShort2);
                if (i7 >= 6) {
                    i7 = unsignedShort2 - 8;
                    cVar.write(bArr2);
                }
                while (i7 > 0) {
                    int i8 = bVar.read(bArr, 0, Math.min(i7, 4096));
                    if (i8 >= 0) {
                        cVar.write(bArr, 0, i8);
                        i7 -= i8;
                    }
                }
            }
        }
        throw new IOException("Invalid marker");
    }

    public final void B(BufferedInputStream bufferedInputStream, BufferedOutputStream bufferedOutputStream) throws Throwable {
        if (f3401t) {
            Log.d("ExifInterface", "savePngAttributes starting with (inputStream: " + bufferedInputStream + ", outputStream: " + bufferedOutputStream + ")");
        }
        b bVar = new b(bufferedInputStream);
        ByteOrder byteOrder = ByteOrder.BIG_ENDIAN;
        c cVar = new c(bufferedOutputStream, byteOrder);
        D.s(bVar, cVar, f3374E.length);
        if (this.f3419o == 0) {
            int i = bVar.readInt();
            cVar.f(i);
            D.s(bVar, cVar, i + 8);
        } else {
            D.s(bVar, cVar, (r2 - r7.length) - 8);
            bVar.d(bVar.readInt() + 8);
        }
        ByteArrayOutputStream byteArrayOutputStream = null;
        try {
            ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
            try {
                c cVar2 = new c(byteArrayOutputStream2, byteOrder);
                I(cVar2);
                byte[] byteArray = ((ByteArrayOutputStream) cVar2.f3358a).toByteArray();
                cVar.write(byteArray);
                CRC32 crc32 = new CRC32();
                crc32.update(byteArray, 4, byteArray.length - 4);
                cVar.f((int) crc32.getValue());
                D.q(byteArrayOutputStream2);
                D.t(bVar, cVar);
            } catch (Throwable th) {
                th = th;
                byteArrayOutputStream = byteArrayOutputStream2;
                D.q(byteArrayOutputStream);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public final void C(BufferedInputStream bufferedInputStream, BufferedOutputStream bufferedOutputStream) throws Throwable {
        ByteArrayOutputStream byteArrayOutputStream;
        int i;
        int i6;
        int i7;
        int i8;
        ByteArrayOutputStream byteArrayOutputStream2;
        c cVar;
        byte[] bArr;
        boolean z6;
        if (f3401t) {
            Log.d("ExifInterface", "saveWebpAttributes starting with (inputStream: " + bufferedInputStream + ", outputStream: " + bufferedOutputStream + ")");
        }
        ByteOrder byteOrder = ByteOrder.LITTLE_ENDIAN;
        b bVar = new b(bufferedInputStream, byteOrder);
        c cVar2 = new c(bufferedOutputStream, byteOrder);
        byte[] bArr2 = f3378I;
        D.s(bVar, cVar2, bArr2.length);
        byte[] bArr3 = f3379J;
        bVar.d(bArr3.length + 4);
        ByteArrayOutputStream byteArrayOutputStream3 = null;
        try {
            try {
                ByteArrayOutputStream byteArrayOutputStream4 = new ByteArrayOutputStream();
                try {
                    c cVar3 = new c(byteArrayOutputStream4, byteOrder);
                    int i9 = this.f3419o;
                    try {
                        try {
                            if (i9 != 0) {
                                D.s(bVar, cVar3, (i9 - ((bArr2.length + 4) + bArr3.length)) - 8);
                                bVar.d(4);
                                int i10 = bVar.readInt();
                                if (i10 % 2 != 0) {
                                    i10++;
                                }
                                bVar.d(i10);
                                I(cVar3);
                            } else {
                                byte[] bArr4 = new byte[4];
                                bVar.readFully(bArr4);
                                byte[] bArr5 = f3382M;
                                boolean zEquals = Arrays.equals(bArr4, bArr5);
                                byte[] bArr6 = f3383O;
                                byte[] bArr7 = N;
                                if (!zEquals) {
                                    if (Arrays.equals(bArr4, bArr6) || Arrays.equals(bArr4, bArr7)) {
                                        int i11 = bVar.readInt();
                                        int i12 = i11 % 2 == 1 ? i11 + 1 : i11;
                                        byte[] bArr8 = new byte[3];
                                        boolean zEquals2 = Arrays.equals(bArr4, bArr6);
                                        boolean z7 = true;
                                        byte[] bArr9 = f3381L;
                                        if (zEquals2) {
                                            bVar.readFully(bArr8);
                                            byte[] bArr10 = new byte[3];
                                            bVar.readFully(bArr10);
                                            if (!Arrays.equals(bArr9, bArr10)) {
                                                throw new IOException("Error checking VP8 signature");
                                            }
                                            i = bVar.readInt();
                                            i12 -= 10;
                                            i6 = (i << 18) >> 18;
                                            i7 = (i << 2) >> 18;
                                            z7 = false;
                                        } else if (!Arrays.equals(bArr4, bArr7)) {
                                            i = 0;
                                            i6 = 0;
                                            z7 = false;
                                            i7 = 0;
                                        } else {
                                            if (bVar.readByte() != 47) {
                                                throw new IOException("Error checking VP8L signature");
                                            }
                                            i = bVar.readInt();
                                            i6 = (i & 16383) + 1;
                                            i7 = ((i & 268419072) >>> 14) + 1;
                                            if ((i & 268435456) == 0) {
                                                z7 = false;
                                            }
                                            i12 -= 5;
                                        }
                                        cVar3.write(bArr5);
                                        cVar3.f(10);
                                        byte[] bArr11 = new byte[10];
                                        if (z7) {
                                            i8 = i6;
                                            bArr11[0] = (byte) (bArr11[0] | 16);
                                        } else {
                                            i8 = i6;
                                        }
                                        bArr11[0] = (byte) (bArr11[0] | 8);
                                        int i13 = i8 - 1;
                                        byteArrayOutputStream2 = byteArrayOutputStream4;
                                        int i14 = i7 - 1;
                                        cVar = cVar2;
                                        try {
                                            bArr11[4] = (byte) i13;
                                            bArr11[5] = (byte) (i13 >> 8);
                                            bArr11[6] = (byte) (i13 >> 16);
                                            bArr11[7] = (byte) i14;
                                            bArr11[8] = (byte) (i14 >> 8);
                                            bArr11[9] = (byte) (i14 >> 16);
                                            cVar3.write(bArr11);
                                            cVar3.write(bArr4);
                                            cVar3.f(i11);
                                        } catch (Exception e) {
                                            e = e;
                                            byteArrayOutputStream = byteArrayOutputStream2;
                                            byteArrayOutputStream3 = byteArrayOutputStream;
                                            throw new IOException("Failed to save WebP file", e);
                                        } catch (Throwable th) {
                                            th = th;
                                            byteArrayOutputStream = byteArrayOutputStream2;
                                            byteArrayOutputStream3 = byteArrayOutputStream;
                                            D.q(byteArrayOutputStream3);
                                            throw th;
                                        }
                                        try {
                                            if (Arrays.equals(bArr4, bArr6)) {
                                                cVar3.write(bArr8);
                                                cVar3.write(bArr9);
                                                cVar3.f(i);
                                            } else {
                                                if (Arrays.equals(bArr4, bArr7)) {
                                                    cVar3.write(47);
                                                    cVar3.f(i);
                                                }
                                                D.s(bVar, cVar3, i12);
                                                I(cVar3);
                                            }
                                            D.s(bVar, cVar3, i12);
                                            I(cVar3);
                                        } catch (Exception e2) {
                                            e = e2;
                                            byteArrayOutputStream3 = byteArrayOutputStream2;
                                            throw new IOException("Failed to save WebP file", e);
                                        } catch (Throwable th2) {
                                            th = th2;
                                            byteArrayOutputStream3 = byteArrayOutputStream2;
                                            D.q(byteArrayOutputStream3);
                                            throw th;
                                        }
                                    }
                                    D.t(bVar, cVar3);
                                    c cVar4 = cVar;
                                    cVar4.f(byteArrayOutputStream2.size() + bArr3.length);
                                    cVar4.write(bArr3);
                                    byteArrayOutputStream = byteArrayOutputStream2;
                                    byteArrayOutputStream.writeTo(cVar4);
                                    D.q(byteArrayOutputStream);
                                    return;
                                }
                                int i15 = bVar.readInt();
                                byte[] bArr12 = new byte[i15 % 2 == 1 ? i15 + 1 : i15];
                                bVar.readFully(bArr12);
                                byte b3 = (byte) (8 | bArr12[0]);
                                bArr12[0] = b3;
                                boolean z8 = ((b3 >> 1) & 1) == 1;
                                cVar3.write(bArr5);
                                cVar3.f(i15);
                                cVar3.write(bArr12);
                                if (z8) {
                                    byte[] bArr13 = P;
                                    do {
                                        bArr = new byte[4];
                                        bVar.readFully(bArr);
                                        int i16 = bVar.readInt();
                                        cVar3.write(bArr);
                                        cVar3.f(i16);
                                        if (i16 % 2 == 1) {
                                            i16++;
                                        }
                                        D.s(bVar, cVar3, i16);
                                    } while (!Arrays.equals(bArr, bArr13));
                                    while (true) {
                                        byte[] bArr14 = new byte[4];
                                        try {
                                            bVar.readFully(bArr14);
                                            z6 = !Arrays.equals(bArr14, f3384Q);
                                        } catch (EOFException unused) {
                                            z6 = true;
                                        }
                                        if (z6) {
                                            break;
                                        }
                                        int i17 = bVar.readInt();
                                        cVar3.write(bArr14);
                                        cVar3.f(i17);
                                        if (i17 % 2 == 1) {
                                            i17++;
                                        }
                                        D.s(bVar, cVar3, i17);
                                    }
                                    I(cVar3);
                                } else {
                                    while (true) {
                                        byte[] bArr15 = new byte[4];
                                        bVar.readFully(bArr15);
                                        int i18 = bVar.readInt();
                                        cVar3.write(bArr15);
                                        cVar3.f(i18);
                                        if (i18 % 2 == 1) {
                                            i18++;
                                        }
                                        D.s(bVar, cVar3, i18);
                                        if (Arrays.equals(bArr15, bArr6) || (bArr7 != null && Arrays.equals(bArr15, bArr7))) {
                                            break;
                                        }
                                    }
                                    I(cVar3);
                                }
                            }
                            byteArrayOutputStream.writeTo(cVar4);
                            D.q(byteArrayOutputStream);
                            return;
                        } catch (Exception e6) {
                            e = e6;
                            byteArrayOutputStream3 = byteArrayOutputStream;
                            throw new IOException("Failed to save WebP file", e);
                        } catch (Throwable th3) {
                            th = th3;
                            byteArrayOutputStream3 = byteArrayOutputStream;
                            D.q(byteArrayOutputStream3);
                            throw th;
                        }
                        cVar = cVar2;
                        byteArrayOutputStream2 = byteArrayOutputStream4;
                        D.t(bVar, cVar3);
                        c cVar42 = cVar;
                        cVar42.f(byteArrayOutputStream2.size() + bArr3.length);
                        cVar42.write(bArr3);
                        byteArrayOutputStream = byteArrayOutputStream2;
                    } catch (Exception e7) {
                        e = e7;
                        byteArrayOutputStream3 = byteArrayOutputStream4;
                    } catch (Throwable th4) {
                        th = th4;
                        byteArrayOutputStream3 = byteArrayOutputStream4;
                    }
                } catch (Exception e8) {
                    e = e8;
                    byteArrayOutputStream = byteArrayOutputStream4;
                } catch (Throwable th5) {
                    th = th5;
                    byteArrayOutputStream = byteArrayOutputStream4;
                }
            } catch (Exception e9) {
                e = e9;
            }
        } catch (Throwable th6) {
            th = th6;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x02df  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x032a  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x0369  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x0394  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x03bf  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x03d0  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0205  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x021a  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0266  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void D(java.lang.String r21, java.lang.String r22) {
        /*
            Method dump skipped, instruction units count: 1078
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: X.h.D(java.lang.String, java.lang.String):void");
    }

    public final void E(b bVar) throws Throwable {
        String str;
        d dVar;
        int iH;
        HashMap map = this.e[4];
        d dVar2 = (d) map.get("Compression");
        if (dVar2 == null) {
            this.f3418n = 6;
            p(bVar, map);
            return;
        }
        int iH2 = dVar2.h(this.f3412g);
        this.f3418n = iH2;
        int i = 1;
        if (iH2 != 1) {
            if (iH2 == 6) {
                p(bVar, map);
                return;
            } else if (iH2 != 7) {
                return;
            }
        }
        d dVar3 = (d) map.get("BitsPerSample");
        String str2 = "ExifInterface";
        if (dVar3 != null) {
            int[] iArr = (int[]) dVar3.j(this.f3412g);
            int[] iArr2 = f3404w;
            if (Arrays.equals(iArr2, iArr) || (this.f3410d == 3 && (dVar = (d) map.get("PhotometricInterpretation")) != null && (((iH = dVar.h(this.f3412g)) == 1 && Arrays.equals(iArr, f3405x)) || (iH == 6 && Arrays.equals(iArr, iArr2))))) {
                d dVar4 = (d) map.get("StripOffsets");
                d dVar5 = (d) map.get("StripByteCounts");
                if (dVar4 == null || dVar5 == null) {
                    return;
                }
                long[] jArrR = D.r(dVar4.j(this.f3412g));
                long[] jArrR2 = D.r(dVar5.j(this.f3412g));
                if (jArrR == null || jArrR.length == 0) {
                    Log.w("ExifInterface", "stripOffsets should not be null or have zero length.");
                    return;
                }
                if (jArrR2 == null || jArrR2.length == 0) {
                    Log.w("ExifInterface", "stripByteCounts should not be null or have zero length.");
                    return;
                }
                if (jArrR.length != jArrR2.length) {
                    Log.w("ExifInterface", "stripOffsets and stripByteCounts should have same length.");
                    return;
                }
                long j4 = 0;
                for (long j6 : jArrR2) {
                    j4 += j6;
                }
                int i6 = (int) j4;
                byte[] bArr = new byte[i6];
                this.f3414j = true;
                this.i = true;
                this.f3413h = true;
                int i7 = 0;
                int i8 = 0;
                int i9 = 0;
                while (i7 < jArrR.length) {
                    int i10 = (int) jArrR[i7];
                    int i11 = (int) jArrR2[i7];
                    if (i7 < jArrR.length - i) {
                        str = str2;
                        if (i10 + i11 != jArrR[i7 + 1]) {
                            this.f3414j = false;
                        }
                    } else {
                        str = str2;
                    }
                    int i12 = i10 - i8;
                    if (i12 < 0) {
                        Log.d(str, "Invalid strip offset value");
                        return;
                    }
                    String str3 = str;
                    try {
                        bVar.d(i12);
                        int i13 = i8 + i12;
                        byte[] bArr2 = new byte[i11];
                        try {
                            bVar.readFully(bArr2);
                            i8 = i13 + i11;
                            System.arraycopy(bArr2, 0, bArr, i9, i11);
                            i9 += i11;
                            i7++;
                            str2 = str3;
                            i = 1;
                        } catch (EOFException unused) {
                            Log.d(str3, "Failed to read " + i11 + " bytes.");
                            return;
                        }
                    } catch (EOFException unused2) {
                        Log.d(str3, "Failed to skip " + i12 + " bytes.");
                        return;
                    }
                }
                this.f3417m = bArr;
                if (this.f3414j) {
                    this.f3415k = (int) jArrR[0];
                    this.f3416l = i6;
                    return;
                }
                return;
            }
        }
        if (f3401t) {
            Log.d("ExifInterface", "Unsupported data type value");
        }
    }

    public final void F(int i, int i6) throws Throwable {
        HashMap[] mapArr = this.e;
        boolean zIsEmpty = mapArr[i].isEmpty();
        boolean z6 = f3401t;
        if (zIsEmpty || mapArr[i6].isEmpty()) {
            if (z6) {
                Log.d("ExifInterface", "Cannot perform swap since only one image data exists");
                return;
            }
            return;
        }
        d dVar = (d) mapArr[i].get("ImageLength");
        d dVar2 = (d) mapArr[i].get("ImageWidth");
        d dVar3 = (d) mapArr[i6].get("ImageLength");
        d dVar4 = (d) mapArr[i6].get("ImageWidth");
        if (dVar == null || dVar2 == null) {
            if (z6) {
                Log.d("ExifInterface", "First image does not contain valid size information");
                return;
            }
            return;
        }
        if (dVar3 == null || dVar4 == null) {
            if (z6) {
                Log.d("ExifInterface", "Second image does not contain valid size information");
                return;
            }
            return;
        }
        int iH = dVar.h(this.f3412g);
        int iH2 = dVar2.h(this.f3412g);
        int iH3 = dVar3.h(this.f3412g);
        int iH4 = dVar4.h(this.f3412g);
        if (iH >= iH3 || iH2 >= iH4) {
            return;
        }
        HashMap map = mapArr[i];
        mapArr[i] = mapArr[i6];
        mapArr[i6] = map;
    }

    public final void G(g gVar, int i) throws Throwable {
        d dVarE;
        d dVarE2;
        HashMap[] mapArr = this.e;
        d dVar = (d) mapArr[i].get("DefaultCropSize");
        d dVar2 = (d) mapArr[i].get("SensorTopBorder");
        d dVar3 = (d) mapArr[i].get("SensorLeftBorder");
        d dVar4 = (d) mapArr[i].get("SensorBottomBorder");
        d dVar5 = (d) mapArr[i].get("SensorRightBorder");
        if (dVar != null) {
            if (dVar.f3360a == 5) {
                f[] fVarArr = (f[]) dVar.j(this.f3412g);
                if (fVarArr == null || fVarArr.length != 2) {
                    Log.w("ExifInterface", "Invalid crop size values. cropSize=" + Arrays.toString(fVarArr));
                    return;
                } else {
                    dVarE = d.d(new f[]{fVarArr[0]}, this.f3412g);
                    dVarE2 = d.d(new f[]{fVarArr[1]}, this.f3412g);
                }
            } else {
                int[] iArr = (int[]) dVar.j(this.f3412g);
                if (iArr == null || iArr.length != 2) {
                    Log.w("ExifInterface", "Invalid crop size values. cropSize=" + Arrays.toString(iArr));
                    return;
                }
                dVarE = d.e(iArr[0], this.f3412g);
                dVarE2 = d.e(iArr[1], this.f3412g);
            }
            mapArr[i].put("ImageWidth", dVarE);
            mapArr[i].put("ImageLength", dVarE2);
            return;
        }
        if (dVar2 != null && dVar3 != null && dVar4 != null && dVar5 != null) {
            int iH = dVar2.h(this.f3412g);
            int iH2 = dVar4.h(this.f3412g);
            int iH3 = dVar5.h(this.f3412g);
            int iH4 = dVar3.h(this.f3412g);
            if (iH2 <= iH || iH3 <= iH4) {
                return;
            }
            d dVarE3 = d.e(iH2 - iH, this.f3412g);
            d dVarE4 = d.e(iH3 - iH4, this.f3412g);
            mapArr[i].put("ImageLength", dVarE3);
            mapArr[i].put("ImageWidth", dVarE4);
            return;
        }
        d dVar6 = (d) mapArr[i].get("ImageLength");
        d dVar7 = (d) mapArr[i].get("ImageWidth");
        if (dVar6 == null || dVar7 == null) {
            d dVar8 = (d) mapArr[i].get("JPEGInterchangeFormat");
            d dVar9 = (d) mapArr[i].get("JPEGInterchangeFormatLength");
            if (dVar8 == null || dVar9 == null) {
                return;
            }
            int iH5 = dVar8.h(this.f3412g);
            int iH6 = dVar8.h(this.f3412g);
            gVar.f(iH5);
            byte[] bArr = new byte[iH6];
            gVar.readFully(bArr);
            e(new b(bArr), iH5, i);
        }
    }

    public final void H() throws Throwable {
        F(0, 5);
        F(0, 4);
        F(5, 4);
        HashMap[] mapArr = this.e;
        d dVar = (d) mapArr[1].get("PixelXDimension");
        d dVar2 = (d) mapArr[1].get("PixelYDimension");
        if (dVar != null && dVar2 != null) {
            mapArr[0].put("ImageWidth", dVar);
            mapArr[0].put("ImageLength", dVar2);
        }
        if (mapArr[4].isEmpty() && q(mapArr[5])) {
            mapArr[4] = mapArr[5];
            mapArr[5] = new HashMap();
        }
        if (!q(mapArr[4])) {
            Log.d("ExifInterface", "No image meets the size requirements of a thumbnail image.");
        }
        y("ThumbnailOrientation", 0, "Orientation");
        y("ThumbnailImageLength", 0, "ImageLength");
        y("ThumbnailImageWidth", 0, "ImageWidth");
        y("ThumbnailOrientation", 5, "Orientation");
        y("ThumbnailImageLength", 5, "ImageLength");
        y("ThumbnailImageWidth", 5, "ImageWidth");
        y("Orientation", 4, "ThumbnailOrientation");
        y("ImageLength", 4, "ThumbnailImageLength");
        y("ImageWidth", 4, "ThumbnailImageWidth");
    }

    public final void I(c cVar) throws IOException {
        HashMap[] mapArr;
        char c6;
        char c7;
        int i;
        int[] iArr;
        int[] iArr2;
        int[] iArr3;
        e[][] eVarArr = f3389V;
        int[] iArr4 = new int[eVarArr.length];
        int[] iArr5 = new int[eVarArr.length];
        e[] eVarArr2 = f3390W;
        for (e eVar : eVarArr2) {
            x(eVar.f3365b);
        }
        if (this.f3413h) {
            if (this.i) {
                x("StripOffsets");
                x("StripByteCounts");
            } else {
                x("JPEGInterchangeFormat");
                x("JPEGInterchangeFormatLength");
            }
        }
        int i6 = 0;
        while (true) {
            int length = eVarArr.length;
            mapArr = this.e;
            if (i6 >= length) {
                break;
            }
            Object[] array = mapArr[i6].entrySet().toArray();
            int length2 = array.length;
            int i7 = 0;
            while (i7 < length2) {
                Map.Entry entry = (Map.Entry) array[i7];
                if (entry.getValue() == null) {
                    iArr3 = iArr4;
                    mapArr[i6].remove(entry.getKey());
                } else {
                    iArr3 = iArr4;
                }
                i7++;
                iArr4 = iArr3;
            }
            i6++;
        }
        int[] iArr6 = iArr4;
        if (!mapArr[1].isEmpty()) {
            mapArr[0].put(eVarArr2[1].f3365b, d.b(0L, this.f3412g));
        }
        if (mapArr[2].isEmpty()) {
            c6 = 2;
        } else {
            c6 = 2;
            mapArr[0].put(eVarArr2[2].f3365b, d.b(0L, this.f3412g));
        }
        if (mapArr[3].isEmpty()) {
            c7 = 3;
        } else {
            c7 = 3;
            mapArr[1].put(eVarArr2[3].f3365b, d.b(0L, this.f3412g));
        }
        if (!this.f3413h) {
            i = 1;
            iArr = iArr5;
        } else if (this.i) {
            mapArr[4].put("StripOffsets", d.e(0, this.f3412g));
            mapArr[4].put("StripByteCounts", d.e(this.f3416l, this.f3412g));
            i = 1;
            iArr = iArr5;
        } else {
            mapArr[4].put("JPEGInterchangeFormat", d.b(0L, this.f3412g));
            i = 1;
            iArr = iArr5;
            mapArr[4].put("JPEGInterchangeFormatLength", d.b(this.f3416l, this.f3412g));
        }
        int i8 = 0;
        while (true) {
            int length3 = eVarArr.length;
            iArr2 = f3386S;
            if (i8 >= length3) {
                break;
            }
            Iterator it = mapArr[i8].entrySet().iterator();
            int i9 = 0;
            while (it.hasNext()) {
                d dVar = (d) ((Map.Entry) it.next()).getValue();
                dVar.getClass();
                int i10 = iArr2[dVar.f3360a] * dVar.f3361b;
                if (i10 > 4) {
                    i9 += i10;
                }
            }
            iArr[i8] = iArr[i8] + i9;
            i8++;
        }
        int size = 8;
        for (int i11 = 0; i11 < eVarArr.length; i11++) {
            if (!mapArr[i11].isEmpty()) {
                iArr6[i11] = size;
                size = (mapArr[i11].size() * 12) + 6 + iArr[i11] + size;
            }
        }
        if (this.f3413h) {
            if (this.i) {
                mapArr[4].put("StripOffsets", d.e(size, this.f3412g));
            } else {
                mapArr[4].put("JPEGInterchangeFormat", d.b(size, this.f3412g));
            }
            this.f3415k = size;
            size += this.f3416l;
        }
        if (this.f3410d == 4) {
            size += 8;
        }
        if (f3401t) {
            for (int i12 = 0; i12 < eVarArr.length; i12++) {
                Log.d("ExifInterface", String.format("index: %d, offsets: %d, tag count: %d, data sizes: %d, total size: %d", Integer.valueOf(i12), Integer.valueOf(iArr6[i12]), Integer.valueOf(mapArr[i12].size()), Integer.valueOf(iArr[i12]), Integer.valueOf(size)));
            }
        }
        if (!mapArr[i].isEmpty()) {
            mapArr[0].put(eVarArr2[i].f3365b, d.b(iArr6[i], this.f3412g));
        }
        if (!mapArr[c6].isEmpty()) {
            mapArr[0].put(eVarArr2[c6].f3365b, d.b(iArr6[c6], this.f3412g));
        }
        if (!mapArr[c7].isEmpty()) {
            mapArr[i].put(eVarArr2[c7].f3365b, d.b(iArr6[c7], this.f3412g));
        }
        int i13 = this.f3410d;
        if (i13 == 4) {
            if (size > 65535) {
                throw new IllegalStateException(a3.d.i("Size of exif data (", size, " bytes) exceeds the max size of a JPEG APP1 segment (65536 bytes)"));
            }
            cVar.i(size);
            cVar.write(f3396c0);
        } else if (i13 == 13) {
            cVar.f(size);
            cVar.write(f3375F);
        } else if (i13 == 14) {
            cVar.write(f3380K);
            cVar.f(size);
        }
        cVar.g(this.f3412g == ByteOrder.BIG_ENDIAN ? (short) 19789 : (short) 18761);
        cVar.f3359b = this.f3412g;
        cVar.i(42);
        cVar.h(8L);
        for (int i14 = 0; i14 < eVarArr.length; i14++) {
            if (!mapArr[i14].isEmpty()) {
                cVar.i(mapArr[i14].size());
                int size2 = (mapArr[i14].size() * 12) + iArr6[i14] + 2 + 4;
                for (Map.Entry entry2 : mapArr[i14].entrySet()) {
                    int i15 = ((e) f3392Y[i14].get(entry2.getKey())).f3364a;
                    d dVar2 = (d) entry2.getValue();
                    dVar2.getClass();
                    int i16 = dVar2.f3360a;
                    int i17 = iArr2[i16];
                    int i18 = dVar2.f3361b;
                    int i19 = i17 * i18;
                    cVar.i(i15);
                    cVar.i(i16);
                    cVar.f(i18);
                    if (i19 > 4) {
                        cVar.h(size2);
                        size2 += i19;
                    } else {
                        cVar.write(dVar2.f3363d);
                        if (i19 < 4) {
                            while (i19 < 4) {
                                cVar.d(0);
                                i19++;
                            }
                        }
                    }
                }
                if (i14 != 0 || mapArr[4].isEmpty()) {
                    cVar.h(0L);
                } else {
                    cVar.h(iArr6[4]);
                }
                Iterator it2 = mapArr[i14].entrySet().iterator();
                while (it2.hasNext()) {
                    byte[] bArr = ((d) ((Map.Entry) it2.next()).getValue()).f3363d;
                    if (bArr.length > 4) {
                        cVar.write(bArr, 0, bArr.length);
                    }
                }
            }
        }
        if (this.f3413h) {
            cVar.write(m());
        }
        if (this.f3410d == 14 && size % 2 == i) {
            cVar.d(0);
        }
        cVar.f3359b = ByteOrder.BIG_ENDIAN;
    }

    public final void a() {
        String strB = b("DateTimeOriginal");
        HashMap[] mapArr = this.e;
        if (strB != null && b("DateTime") == null) {
            mapArr[0].put("DateTime", d.a(strB));
        }
        if (b("ImageWidth") == null) {
            mapArr[0].put("ImageWidth", d.b(0L, this.f3412g));
        }
        if (b("ImageLength") == null) {
            mapArr[0].put("ImageLength", d.b(0L, this.f3412g));
        }
        if (b("Orientation") == null) {
            mapArr[0].put("Orientation", d.b(0L, this.f3412g));
        }
        if (b("LightSource") == null) {
            mapArr[1].put("LightSource", d.b(0L, this.f3412g));
        }
    }

    public final String b(String str) {
        if (str == null) {
            throw new NullPointerException("tag shouldn't be null");
        }
        d dVarC = c(str);
        if (dVarC != null) {
            if (!f3393Z.contains(str)) {
                return dVarC.i(this.f3412g);
            }
            if (str.equals("GPSTimeStamp")) {
                int i = dVarC.f3360a;
                if (i != 5 && i != 10) {
                    Log.w("ExifInterface", "GPS Timestamp format is not rational. format=" + i);
                    return null;
                }
                f[] fVarArr = (f[]) dVarC.j(this.f3412g);
                if (fVarArr == null || fVarArr.length != 3) {
                    Log.w("ExifInterface", "Invalid GPS Timestamp array. array=" + Arrays.toString(fVarArr));
                    return null;
                }
                f fVar = fVarArr[0];
                Integer numValueOf = Integer.valueOf((int) (fVar.f3368a / fVar.f3369b));
                f fVar2 = fVarArr[1];
                Integer numValueOf2 = Integer.valueOf((int) (fVar2.f3368a / fVar2.f3369b));
                f fVar3 = fVarArr[2];
                return String.format("%02d:%02d:%02d", numValueOf, numValueOf2, Integer.valueOf((int) (fVar3.f3368a / fVar3.f3369b)));
            }
            try {
                return Double.toString(dVarC.g(this.f3412g));
            } catch (NumberFormatException unused) {
            }
        }
        return null;
    }

    public final d c(String str) {
        if (str == null) {
            throw new NullPointerException("tag shouldn't be null");
        }
        if ("ISOSpeedRatings".equals(str)) {
            if (f3401t) {
                Log.d("ExifInterface", "getExifAttribute: Replacing TAG_ISO_SPEED_RATINGS with TAG_PHOTOGRAPHIC_SENSITIVITY.");
            }
            str = "PhotographicSensitivity";
        }
        for (int i = 0; i < f3389V.length; i++) {
            d dVar = (d) this.e[i].get(str);
            if (dVar != null) {
                return dVar;
            }
        }
        return null;
    }

    public final void d(g gVar) throws IOException {
        String strExtractMetadata;
        String strExtractMetadata2;
        String strExtractMetadata3;
        if (Build.VERSION.SDK_INT < 28) {
            throw new UnsupportedOperationException("Reading EXIF from HEIF files is supported from SDK 28 and above");
        }
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        try {
            try {
                j.a(mediaMetadataRetriever, new a(gVar));
                String strExtractMetadata4 = mediaMetadataRetriever.extractMetadata(33);
                String strExtractMetadata5 = mediaMetadataRetriever.extractMetadata(34);
                String strExtractMetadata6 = mediaMetadataRetriever.extractMetadata(26);
                String strExtractMetadata7 = mediaMetadataRetriever.extractMetadata(17);
                if ("yes".equals(strExtractMetadata6)) {
                    strExtractMetadata = mediaMetadataRetriever.extractMetadata(29);
                    strExtractMetadata2 = mediaMetadataRetriever.extractMetadata(30);
                    strExtractMetadata3 = mediaMetadataRetriever.extractMetadata(31);
                } else if ("yes".equals(strExtractMetadata7)) {
                    strExtractMetadata = mediaMetadataRetriever.extractMetadata(18);
                    strExtractMetadata2 = mediaMetadataRetriever.extractMetadata(19);
                    strExtractMetadata3 = mediaMetadataRetriever.extractMetadata(24);
                } else {
                    strExtractMetadata = null;
                    strExtractMetadata2 = null;
                    strExtractMetadata3 = null;
                }
                HashMap[] mapArr = this.e;
                if (strExtractMetadata != null) {
                    mapArr[0].put("ImageWidth", d.e(Integer.parseInt(strExtractMetadata), this.f3412g));
                }
                if (strExtractMetadata2 != null) {
                    mapArr[0].put("ImageLength", d.e(Integer.parseInt(strExtractMetadata2), this.f3412g));
                }
                if (strExtractMetadata3 != null) {
                    int i = Integer.parseInt(strExtractMetadata3);
                    mapArr[0].put("Orientation", d.e(i != 90 ? i != 180 ? i != 270 ? 1 : 8 : 3 : 6, this.f3412g));
                }
                if (strExtractMetadata4 != null && strExtractMetadata5 != null) {
                    int i6 = Integer.parseInt(strExtractMetadata4);
                    int i7 = Integer.parseInt(strExtractMetadata5);
                    if (i7 <= 6) {
                        throw new IOException("Invalid exif length");
                    }
                    gVar.f(i6);
                    byte[] bArr = new byte[6];
                    gVar.readFully(bArr);
                    int i8 = i6 + 6;
                    int i9 = i7 - 6;
                    if (!Arrays.equals(bArr, f3396c0)) {
                        throw new IOException("Invalid identifier");
                    }
                    byte[] bArr2 = new byte[i9];
                    gVar.readFully(bArr2);
                    this.f3419o = i8;
                    v(bArr2, 0);
                }
                if (f3401t) {
                    Log.d("ExifInterface", "Heif meta: " + strExtractMetadata + "x" + strExtractMetadata2 + ", rotation " + strExtractMetadata3);
                }
                mediaMetadataRetriever.release();
            } catch (RuntimeException unused) {
                throw new UnsupportedOperationException("Failed to read EXIF from HEIF file. Given stream is either malformed or unsupported.");
            }
        } catch (Throwable th) {
            mediaMetadataRetriever.release();
            throw th;
        }
    }

    /*  JADX ERROR: UnsupportedOperationException in pass: RegionMakerVisitor
        java.lang.UnsupportedOperationException
        	at java.base/java.util.Collections$UnmodifiableCollection.add(Collections.java:1060)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker$1.leaveRegion(SwitchRegionMaker.java:390)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:70)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1541)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverse(DepthRegionTraversal.java:23)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker.insertBreaksForCase(SwitchRegionMaker.java:370)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker.insertBreaks(SwitchRegionMaker.java:85)
        	at jadx.core.dex.visitors.regions.PostProcessRegions.leaveRegion(PostProcessRegions.java:33)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:70)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1541)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1541)
        	at java.base/java.util.Collections$UnmodifiableCollection.forEach(Collections.java:1085)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1541)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1541)
        	at java.base/java.util.Collections$UnmodifiableCollection.forEach(Collections.java:1085)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1541)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1541)
        	at java.base/java.util.Collections$UnmodifiableCollection.forEach(Collections.java:1085)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1541)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1541)
        	at java.base/java.util.Collections$UnmodifiableCollection.forEach(Collections.java:1085)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1541)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1541)
        	at java.base/java.util.Collections$UnmodifiableCollection.forEach(Collections.java:1085)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1541)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1541)
        	at java.base/java.util.Collections$UnmodifiableCollection.forEach(Collections.java:1085)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1541)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1541)
        	at java.base/java.util.Collections$UnmodifiableCollection.forEach(Collections.java:1085)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1541)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1541)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1541)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1541)
        	at java.base/java.util.Collections$UnmodifiableCollection.forEach(Collections.java:1085)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1541)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1541)
        	at java.base/java.util.Collections$UnmodifiableCollection.forEach(Collections.java:1085)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1541)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverse(DepthRegionTraversal.java:19)
        	at jadx.core.dex.visitors.regions.PostProcessRegions.process(PostProcessRegions.java:23)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:31)
        */
    public final void e(X.b r24, int r25, int r26) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 522
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: X.h.e(X.b, int, int):void");
    }

    /* JADX WARN: Can't wrap try/catch for region: R(12:169|12|(4:164|13|150|14)|(16:17|(2:19|20)(1:28)|23|29|(1:31)|32|(4:152|35|(7:154|39|40|(3:43|(1:45)(2:46|(1:48))|(1:179)(3:177|51|52))(1:180)|53|36|37)|176)|34|160|65|162|66|67|(1:73)(1:72)|74|(1:87)(8:156|89|158|90|91|(1:93)(1:94)|95|(1:107)(3:109|(2:110|(2:112|(2:170|114)(1:115))(2:171|116))|(1:118)(4:120|(2:121|(2:123|(1:173)(1:126))(3:172|127|(2:128|(2:130|(1:175)(1:133))(2:174|134))))|125|(1:136)(1:138)))))|16|160|65|162|66|67|(3:69|73|74)(0)|(0)(0)) */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0061, code lost:
    
        if (r9 < 16) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x00ef, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x00f0, code lost:
    
        r6 = r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x00f2, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x00f4, code lost:
    
        r2 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x00f6, code lost:
    
        if (r6 != null) goto L81;
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x00f8, code lost:
    
        r6.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x00fb, code lost:
    
        throw r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x00fc, code lost:
    
        if (r2 != null) goto L84;
     */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x00fe, code lost:
    
        r2.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:85:0x0101, code lost:
    
        r0 = r18;
     */
    /* JADX WARN: Removed duplicated region for block: B:156:0x0107 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00e2  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x00ea  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0105 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int f(java.io.BufferedInputStream r18) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 409
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: X.h.f(java.io.BufferedInputStream):int");
    }

    public final void g(g gVar) throws Throwable {
        int i;
        int i6;
        j(gVar);
        HashMap[] mapArr = this.e;
        d dVar = (d) mapArr[1].get("MakerNote");
        if (dVar != null) {
            g gVar2 = new g(dVar.f3363d);
            gVar2.f3356c = this.f3412g;
            byte[] bArr = f3372C;
            byte[] bArr2 = new byte[bArr.length];
            gVar2.readFully(bArr2);
            gVar2.f(0L);
            byte[] bArr3 = f3373D;
            byte[] bArr4 = new byte[bArr3.length];
            gVar2.readFully(bArr4);
            if (Arrays.equals(bArr2, bArr)) {
                gVar2.f(8L);
            } else if (Arrays.equals(bArr4, bArr3)) {
                gVar2.f(12L);
            }
            w(gVar2, 6);
            d dVar2 = (d) mapArr[7].get("PreviewImageStart");
            d dVar3 = (d) mapArr[7].get("PreviewImageLength");
            if (dVar2 != null && dVar3 != null) {
                mapArr[5].put("JPEGInterchangeFormat", dVar2);
                mapArr[5].put("JPEGInterchangeFormatLength", dVar3);
            }
            d dVar4 = (d) mapArr[8].get("AspectFrame");
            if (dVar4 != null) {
                int[] iArr = (int[]) dVar4.j(this.f3412g);
                if (iArr == null || iArr.length != 4) {
                    Log.w("ExifInterface", "Invalid aspect frame values. frame=" + Arrays.toString(iArr));
                    return;
                }
                int i7 = iArr[2];
                int i8 = iArr[0];
                if (i7 <= i8 || (i = iArr[3]) <= (i6 = iArr[1])) {
                    return;
                }
                int i9 = (i7 - i8) + 1;
                int i10 = (i - i6) + 1;
                if (i9 < i10) {
                    int i11 = i9 + i10;
                    i10 = i11 - i10;
                    i9 = i11 - i10;
                }
                d dVarE = d.e(i9, this.f3412g);
                d dVarE2 = d.e(i10, this.f3412g);
                mapArr[0].put("ImageWidth", dVarE);
                mapArr[0].put("ImageLength", dVarE2);
            }
        }
    }

    public final void h(b bVar) throws Throwable {
        if (f3401t) {
            Log.d("ExifInterface", "getPngAttributes starting with: " + bVar);
        }
        bVar.f3356c = ByteOrder.BIG_ENDIAN;
        byte[] bArr = f3374E;
        bVar.d(bArr.length);
        int length = bArr.length;
        while (true) {
            try {
                int i = bVar.readInt();
                byte[] bArr2 = new byte[4];
                bVar.readFully(bArr2);
                int i6 = length + 8;
                if (i6 == 16 && !Arrays.equals(bArr2, f3376G)) {
                    throw new IOException("Encountered invalid PNG file--IHDR chunk should appearas the first chunk");
                }
                if (Arrays.equals(bArr2, f3377H)) {
                    return;
                }
                if (Arrays.equals(bArr2, f3375F)) {
                    byte[] bArr3 = new byte[i];
                    bVar.readFully(bArr3);
                    int i7 = bVar.readInt();
                    CRC32 crc32 = new CRC32();
                    crc32.update(bArr2);
                    crc32.update(bArr3);
                    if (((int) crc32.getValue()) == i7) {
                        this.f3419o = i6;
                        v(bArr3, 0);
                        H();
                        E(new b(bArr3));
                        return;
                    }
                    throw new IOException("Encountered invalid CRC value for PNG-EXIF chunk.\n recorded CRC value: " + i7 + ", calculated CRC value: " + crc32.getValue());
                }
                int i8 = i + 4;
                bVar.d(i8);
                length = i6 + i8;
            } catch (EOFException unused) {
                throw new IOException("Encountered corrupt PNG file.");
            }
        }
    }

    public final void i(b bVar) throws Throwable {
        boolean z6 = f3401t;
        if (z6) {
            Log.d("ExifInterface", "getRafAttributes starting with: " + bVar);
        }
        bVar.d(84);
        byte[] bArr = new byte[4];
        byte[] bArr2 = new byte[4];
        byte[] bArr3 = new byte[4];
        bVar.readFully(bArr);
        bVar.readFully(bArr2);
        bVar.readFully(bArr3);
        int i = ByteBuffer.wrap(bArr).getInt();
        int i6 = ByteBuffer.wrap(bArr2).getInt();
        int i7 = ByteBuffer.wrap(bArr3).getInt();
        byte[] bArr4 = new byte[i6];
        bVar.d(i - bVar.f3355b);
        bVar.readFully(bArr4);
        e(new b(bArr4), i, 5);
        bVar.d(i7 - bVar.f3355b);
        bVar.f3356c = ByteOrder.BIG_ENDIAN;
        int i8 = bVar.readInt();
        if (z6) {
            Log.d("ExifInterface", "numberOfDirectoryEntry: " + i8);
        }
        for (int i9 = 0; i9 < i8; i9++) {
            int unsignedShort = bVar.readUnsignedShort();
            int unsignedShort2 = bVar.readUnsignedShort();
            if (unsignedShort == f3388U.f3364a) {
                short s6 = bVar.readShort();
                short s7 = bVar.readShort();
                d dVarE = d.e(s6, this.f3412g);
                d dVarE2 = d.e(s7, this.f3412g);
                HashMap[] mapArr = this.e;
                mapArr[0].put("ImageLength", dVarE);
                mapArr[0].put("ImageWidth", dVarE2);
                if (z6) {
                    Log.d("ExifInterface", "Updated to length: " + ((int) s6) + ", width: " + ((int) s7));
                    return;
                }
                return;
            }
            bVar.d(unsignedShort2);
        }
    }

    public final void j(g gVar) throws Throwable {
        s(gVar);
        w(gVar, 0);
        G(gVar, 0);
        G(gVar, 5);
        G(gVar, 4);
        H();
        if (this.f3410d == 8) {
            HashMap[] mapArr = this.e;
            d dVar = (d) mapArr[1].get("MakerNote");
            if (dVar != null) {
                g gVar2 = new g(dVar.f3363d);
                gVar2.f3356c = this.f3412g;
                gVar2.d(6);
                w(gVar2, 9);
                d dVar2 = (d) mapArr[9].get("ColorSpace");
                if (dVar2 != null) {
                    mapArr[1].put("ColorSpace", dVar2);
                }
            }
        }
    }

    public final int k() {
        int iH;
        d dVarC = c("Orientation");
        if (dVarC == null) {
            iH = 1;
        } else {
            try {
                iH = dVarC.h(this.f3412g);
            } catch (NumberFormatException unused) {
                iH = 1;
            }
        }
        switch (iH) {
            case 3:
            case 4:
                return 180;
            case 5:
            case 8:
                return 270;
            case 6:
            case 7:
                return 90;
            default:
                return 0;
        }
    }

    public final void l(g gVar) throws Throwable {
        if (f3401t) {
            Log.d("ExifInterface", "getRw2Attributes starting with: " + gVar);
        }
        j(gVar);
        HashMap[] mapArr = this.e;
        d dVar = (d) mapArr[0].get("JpgFromRaw");
        if (dVar != null) {
            e(new b(dVar.f3363d), (int) dVar.f3362c, 5);
        }
        d dVar2 = (d) mapArr[0].get("ISO");
        d dVar3 = (d) mapArr[1].get("PhotographicSensitivity");
        if (dVar2 == null || dVar3 != null) {
            return;
        }
        mapArr[1].put("PhotographicSensitivity", dVar2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0078 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r3v1, types: [byte[]] */
    /* JADX WARN: Type inference failed for: r3v12 */
    /* JADX WARN: Type inference failed for: r3v13 */
    /* JADX WARN: Type inference failed for: r3v15 */
    /* JADX WARN: Type inference failed for: r3v16 */
    /* JADX WARN: Type inference failed for: r3v17 */
    /* JADX WARN: Type inference failed for: r3v2 */
    /* JADX WARN: Type inference failed for: r3v3 */
    /* JADX WARN: Type inference failed for: r3v4 */
    /* JADX WARN: Type inference failed for: r3v5, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r3v6, types: [android.content.res.AssetManager$AssetInputStream, java.io.Closeable, java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r3v7, types: [java.io.Closeable, java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r3v8 */
    /* JADX WARN: Type inference failed for: r4v0 */
    /* JADX WARN: Type inference failed for: r4v1 */
    /* JADX WARN: Type inference failed for: r4v2, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r4v3 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final byte[] m() throws java.lang.Throwable {
        /*
            r10 = this;
            java.lang.String r0 = "Error closing fd."
            java.lang.String r1 = "ExifInterfaceUtils"
            java.lang.String r2 = "ExifInterface"
            boolean r3 = r10.f3413h
            r4 = 0
            if (r3 != 0) goto Ld
            goto L9c
        Ld:
            byte[] r3 = r10.f3417m
            if (r3 == 0) goto L12
            return r3
        L12:
            android.content.res.AssetManager$AssetInputStream r3 = r10.f3409c     // Catch: java.lang.Throwable -> L40 java.lang.Exception -> L43
            if (r3 == 0) goto L34
            boolean r5 = r3.markSupported()     // Catch: java.lang.Throwable -> L21 java.lang.Exception -> L26
            if (r5 == 0) goto L2b
            r3.reset()     // Catch: java.lang.Throwable -> L21 java.lang.Exception -> L26
        L1f:
            r5 = r4
            goto L5d
        L21:
            r2 = move-exception
            r5 = r4
        L23:
            r4 = r3
            goto L9d
        L26:
            r5 = move-exception
            r6 = r5
            r5 = r4
            goto L8b
        L2b:
            java.lang.String r5 = "Cannot read thumbnail from inputstream without mark/reset support"
            android.util.Log.d(r2, r5)     // Catch: java.lang.Throwable -> L21 java.lang.Exception -> L26
            s3.D.q(r3)
            return r4
        L34:
            java.lang.String r3 = r10.f3407a     // Catch: java.lang.Throwable -> L40 java.lang.Exception -> L43
            if (r3 == 0) goto L48
            java.io.FileInputStream r3 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> L40 java.lang.Exception -> L43
            java.lang.String r5 = r10.f3407a     // Catch: java.lang.Throwable -> L40 java.lang.Exception -> L43
            r3.<init>(r5)     // Catch: java.lang.Throwable -> L40 java.lang.Exception -> L43
            goto L1f
        L40:
            r2 = move-exception
            r5 = r4
            goto L9d
        L43:
            r5 = move-exception
            r3 = r4
            r6 = r5
            r5 = r3
            goto L8b
        L48:
            java.io.FileDescriptor r3 = r10.f3408b     // Catch: java.lang.Throwable -> L40 java.lang.Exception -> L43
            java.io.FileDescriptor r3 = X.i.b(r3)     // Catch: java.lang.Throwable -> L40 java.lang.Exception -> L43
            int r5 = android.system.OsConstants.SEEK_SET     // Catch: java.lang.Throwable -> L84 java.lang.Exception -> L87
            r6 = 0
            X.i.c(r3, r6, r5)     // Catch: java.lang.Throwable -> L84 java.lang.Exception -> L87
            java.io.FileInputStream r5 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> L84 java.lang.Exception -> L87
            r5.<init>(r3)     // Catch: java.lang.Throwable -> L84 java.lang.Exception -> L87
            r9 = r5
            r5 = r3
            r3 = r9
        L5d:
            X.b r6 = new X.b     // Catch: java.lang.Throwable -> L80 java.lang.Exception -> L82
            r6.<init>(r3)     // Catch: java.lang.Throwable -> L80 java.lang.Exception -> L82
            int r7 = r10.f3415k     // Catch: java.lang.Throwable -> L80 java.lang.Exception -> L82
            int r8 = r10.f3419o     // Catch: java.lang.Throwable -> L80 java.lang.Exception -> L82
            int r7 = r7 + r8
            r6.d(r7)     // Catch: java.lang.Throwable -> L80 java.lang.Exception -> L82
            int r7 = r10.f3416l     // Catch: java.lang.Throwable -> L80 java.lang.Exception -> L82
            byte[] r7 = new byte[r7]     // Catch: java.lang.Throwable -> L80 java.lang.Exception -> L82
            r6.readFully(r7)     // Catch: java.lang.Throwable -> L80 java.lang.Exception -> L82
            r10.f3417m = r7     // Catch: java.lang.Throwable -> L80 java.lang.Exception -> L82
            s3.D.q(r3)
            if (r5 == 0) goto L7f
            X.i.a(r5)     // Catch: java.lang.Exception -> L7c
            return r7
        L7c:
            android.util.Log.e(r1, r0)
        L7f:
            return r7
        L80:
            r2 = move-exception
            goto L23
        L82:
            r6 = move-exception
            goto L8b
        L84:
            r2 = move-exception
            r5 = r3
            goto L9d
        L87:
            r5 = move-exception
            r6 = r5
            r5 = r3
            r3 = r4
        L8b:
            java.lang.String r7 = "Encountered exception while getting thumbnail"
            android.util.Log.d(r2, r7, r6)     // Catch: java.lang.Throwable -> L80
            s3.D.q(r3)
            if (r5 == 0) goto L9c
            X.i.a(r5)     // Catch: java.lang.Exception -> L99
            goto L9c
        L99:
            android.util.Log.e(r1, r0)
        L9c:
            return r4
        L9d:
            s3.D.q(r4)
            if (r5 == 0) goto La9
            X.i.a(r5)     // Catch: java.lang.Exception -> La6
            goto La9
        La6:
            android.util.Log.e(r1, r0)
        La9:
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: X.h.m():byte[]");
    }

    public final void n(b bVar) throws Throwable {
        if (f3401t) {
            Log.d("ExifInterface", "getWebpAttributes starting with: " + bVar);
        }
        bVar.f3356c = ByteOrder.LITTLE_ENDIAN;
        bVar.d(f3378I.length);
        int i = bVar.readInt() + 8;
        byte[] bArr = f3379J;
        bVar.d(bArr.length);
        int length = bArr.length + 8;
        while (true) {
            try {
                byte[] bArr2 = new byte[4];
                bVar.readFully(bArr2);
                int i6 = bVar.readInt();
                int i7 = length + 8;
                if (Arrays.equals(f3380K, bArr2)) {
                    byte[] bArr3 = new byte[i6];
                    bVar.readFully(bArr3);
                    this.f3419o = i7;
                    v(bArr3, 0);
                    E(new b(bArr3));
                    return;
                }
                if (i6 % 2 == 1) {
                    i6++;
                }
                length = i7 + i6;
                if (length == i) {
                    return;
                }
                if (length > i) {
                    throw new IOException("Encountered WebP file with invalid chunk size");
                }
                bVar.d(i6);
            } catch (EOFException unused) {
                throw new IOException("Encountered corrupt WebP file.");
            }
        }
    }

    public final void p(b bVar, HashMap map) throws Throwable {
        d dVar = (d) map.get("JPEGInterchangeFormat");
        d dVar2 = (d) map.get("JPEGInterchangeFormatLength");
        if (dVar == null || dVar2 == null) {
            return;
        }
        int iH = dVar.h(this.f3412g);
        int iH2 = dVar2.h(this.f3412g);
        if (this.f3410d == 7) {
            iH += this.f3420p;
        }
        if (iH > 0 && iH2 > 0) {
            this.f3413h = true;
            if (this.f3407a == null && this.f3409c == null && this.f3408b == null) {
                byte[] bArr = new byte[iH2];
                bVar.d(iH);
                bVar.readFully(bArr);
                this.f3417m = bArr;
            }
            this.f3415k = iH;
            this.f3416l = iH2;
        }
        if (f3401t) {
            Log.d("ExifInterface", "Setting thumbnail attributes with offset: " + iH + ", length: " + iH2);
        }
    }

    public final boolean q(HashMap map) {
        d dVar = (d) map.get("ImageLength");
        d dVar2 = (d) map.get("ImageWidth");
        if (dVar == null || dVar2 == null) {
            return false;
        }
        return dVar.h(this.f3412g) <= 512 && dVar2.h(this.f3412g) <= 512;
    }

    /* JADX WARN: Removed duplicated region for block: B:43:0x008f A[Catch: all -> 0x0015, TRY_ENTER, TRY_LEAVE, TryCatch #0 {all -> 0x0015, blocks: (B:3:0x0004, B:5:0x0009, B:12:0x001e, B:18:0x003b, B:20:0x0046, B:28:0x005c, B:23:0x004d, B:26:0x0055, B:27:0x0059, B:29:0x0066, B:31:0x006f, B:33:0x0075, B:35:0x007b, B:37:0x0081, B:43:0x008f), top: B:53:0x0004 }] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00a5  */
    /* JADX WARN: Removed duplicated region for block: B:56:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void r(java.io.InputStream r8) {
        /*
            r7 = this;
            boolean r0 = X.h.f3401t
            r1 = 0
            r2 = r1
        L4:
            X.e[][] r3 = X.h.f3389V     // Catch: java.lang.Throwable -> L15 java.lang.UnsupportedOperationException -> L18 java.io.IOException -> L1b
            int r3 = r3.length     // Catch: java.lang.Throwable -> L15 java.lang.UnsupportedOperationException -> L18 java.io.IOException -> L1b
            if (r2 >= r3) goto L1e
            java.util.HashMap[] r3 = r7.e     // Catch: java.lang.Throwable -> L15 java.lang.UnsupportedOperationException -> L18 java.io.IOException -> L1b
            java.util.HashMap r4 = new java.util.HashMap     // Catch: java.lang.Throwable -> L15 java.lang.UnsupportedOperationException -> L18 java.io.IOException -> L1b
            r4.<init>()     // Catch: java.lang.Throwable -> L15 java.lang.UnsupportedOperationException -> L18 java.io.IOException -> L1b
            r3[r2] = r4     // Catch: java.lang.Throwable -> L15 java.lang.UnsupportedOperationException -> L18 java.io.IOException -> L1b
            int r2 = r2 + 1
            goto L4
        L15:
            r8 = move-exception
            goto L97
        L18:
            r8 = move-exception
            goto L8d
        L1b:
            r8 = move-exception
            goto L8d
        L1e:
            java.io.BufferedInputStream r2 = new java.io.BufferedInputStream     // Catch: java.lang.Throwable -> L15 java.lang.UnsupportedOperationException -> L18 java.io.IOException -> L1b
            r3 = 5000(0x1388, float:7.006E-42)
            r2.<init>(r8, r3)     // Catch: java.lang.Throwable -> L15 java.lang.UnsupportedOperationException -> L18 java.io.IOException -> L1b
            int r8 = r7.f(r2)     // Catch: java.lang.Throwable -> L15 java.lang.UnsupportedOperationException -> L18 java.io.IOException -> L1b
            r7.f3410d = r8     // Catch: java.lang.Throwable -> L15 java.lang.UnsupportedOperationException -> L18 java.io.IOException -> L1b
            r3 = 14
            r4 = 13
            r5 = 9
            r6 = 4
            if (r8 == r6) goto L66
            if (r8 == r5) goto L66
            if (r8 == r4) goto L66
            if (r8 != r3) goto L3b
            goto L66
        L3b:
            X.g r8 = new X.g     // Catch: java.lang.Throwable -> L15 java.lang.UnsupportedOperationException -> L18 java.io.IOException -> L1b
            r8.<init>(r2)     // Catch: java.lang.Throwable -> L15 java.lang.UnsupportedOperationException -> L18 java.io.IOException -> L1b
            int r1 = r7.f3410d     // Catch: java.lang.Throwable -> L15 java.lang.UnsupportedOperationException -> L18 java.io.IOException -> L1b
            r2 = 12
            if (r1 != r2) goto L4a
            r7.d(r8)     // Catch: java.lang.Throwable -> L15 java.lang.UnsupportedOperationException -> L18 java.io.IOException -> L1b
            goto L5c
        L4a:
            r2 = 7
            if (r1 != r2) goto L51
            r7.g(r8)     // Catch: java.lang.Throwable -> L15 java.lang.UnsupportedOperationException -> L18 java.io.IOException -> L1b
            goto L5c
        L51:
            r2 = 10
            if (r1 != r2) goto L59
            r7.l(r8)     // Catch: java.lang.Throwable -> L15 java.lang.UnsupportedOperationException -> L18 java.io.IOException -> L1b
            goto L5c
        L59:
            r7.j(r8)     // Catch: java.lang.Throwable -> L15 java.lang.UnsupportedOperationException -> L18 java.io.IOException -> L1b
        L5c:
            int r1 = r7.f3419o     // Catch: java.lang.Throwable -> L15 java.lang.UnsupportedOperationException -> L18 java.io.IOException -> L1b
            long r1 = (long) r1     // Catch: java.lang.Throwable -> L15 java.lang.UnsupportedOperationException -> L18 java.io.IOException -> L1b
            r8.f(r1)     // Catch: java.lang.Throwable -> L15 java.lang.UnsupportedOperationException -> L18 java.io.IOException -> L1b
            r7.E(r8)     // Catch: java.lang.Throwable -> L15 java.lang.UnsupportedOperationException -> L18 java.io.IOException -> L1b
            goto L84
        L66:
            X.b r8 = new X.b     // Catch: java.lang.Throwable -> L15 java.lang.UnsupportedOperationException -> L18 java.io.IOException -> L1b
            r8.<init>(r2)     // Catch: java.lang.Throwable -> L15 java.lang.UnsupportedOperationException -> L18 java.io.IOException -> L1b
            int r2 = r7.f3410d     // Catch: java.lang.Throwable -> L15 java.lang.UnsupportedOperationException -> L18 java.io.IOException -> L1b
            if (r2 != r6) goto L73
            r7.e(r8, r1, r1)     // Catch: java.lang.Throwable -> L15 java.lang.UnsupportedOperationException -> L18 java.io.IOException -> L1b
            goto L84
        L73:
            if (r2 != r4) goto L79
            r7.h(r8)     // Catch: java.lang.Throwable -> L15 java.lang.UnsupportedOperationException -> L18 java.io.IOException -> L1b
            goto L84
        L79:
            if (r2 != r5) goto L7f
            r7.i(r8)     // Catch: java.lang.Throwable -> L15 java.lang.UnsupportedOperationException -> L18 java.io.IOException -> L1b
            goto L84
        L7f:
            if (r2 != r3) goto L84
            r7.n(r8)     // Catch: java.lang.Throwable -> L15 java.lang.UnsupportedOperationException -> L18 java.io.IOException -> L1b
        L84:
            r7.a()
            if (r0 == 0) goto La8
            r7.t()
            return
        L8d:
            if (r0 == 0) goto La0
            java.lang.String r1 = "ExifInterface"
            java.lang.String r2 = "Invalid image: ExifInterface got an unsupported image format file(ExifInterface supports JPEG and some RAW image formats only) or a corrupted JPEG file to ExifInterface."
            android.util.Log.w(r1, r2, r8)     // Catch: java.lang.Throwable -> L15
            goto La0
        L97:
            r7.a()
            if (r0 == 0) goto L9f
            r7.t()
        L9f:
            throw r8
        La0:
            r7.a()
            if (r0 == 0) goto La8
            r7.t()
        La8:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: X.h.r(java.io.InputStream):void");
    }

    public final void s(g gVar) throws IOException {
        ByteOrder byteOrderU = u(gVar);
        this.f3412g = byteOrderU;
        gVar.f3356c = byteOrderU;
        int unsignedShort = gVar.readUnsignedShort();
        int i = this.f3410d;
        if (i != 7 && i != 10 && unsignedShort != 42) {
            throw new IOException("Invalid start code: " + Integer.toHexString(unsignedShort));
        }
        int i6 = gVar.readInt();
        if (i6 < 8) {
            throw new IOException(a3.d.f(i6, "Invalid first Ifd offset: "));
        }
        int i7 = i6 - 8;
        if (i7 > 0) {
            gVar.d(i7);
        }
    }

    public final void t() {
        int i = 0;
        while (true) {
            HashMap[] mapArr = this.e;
            if (i >= mapArr.length) {
                return;
            }
            StringBuilder sbO = a3.d.o("The size of tag group[", i, "]: ");
            sbO.append(mapArr[i].size());
            Log.d("ExifInterface", sbO.toString());
            for (Map.Entry entry : mapArr[i].entrySet()) {
                d dVar = (d) entry.getValue();
                Log.d("ExifInterface", "tagName: " + ((String) entry.getKey()) + ", tagType: " + dVar.toString() + ", tagValue: '" + dVar.i(this.f3412g) + "'");
            }
            i++;
        }
    }

    public final void v(byte[] bArr, int i) throws IOException {
        g gVar = new g(bArr);
        s(gVar);
        w(gVar, i);
    }

    /* JADX WARN: Removed duplicated region for block: B:112:0x022f  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x0253  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x028f  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0148  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x014d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void w(X.g r27, int r28) throws java.io.IOException {
        /*
            Method dump skipped, instruction units count: 927
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: X.h.w(X.g, int):void");
    }

    public final void x(String str) {
        for (int i = 0; i < f3389V.length; i++) {
            this.e[i].remove(str);
        }
    }

    public final void y(String str, int i, String str2) {
        HashMap[] mapArr = this.e;
        if (mapArr[i].isEmpty() || mapArr[i].get(str) == null) {
            return;
        }
        HashMap map = mapArr[i];
        map.put(str2, map.get(str));
        mapArr[i].remove(str);
    }

    /* JADX WARN: Removed duplicated region for block: B:102:0x0152  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x00fa A[Catch: all -> 0x010a, Exception -> 0x010d, TryCatch #19 {Exception -> 0x010d, all -> 0x010a, blocks: (B:80:0x00f6, B:82:0x00fa, B:89:0x0118, B:88:0x0110), top: B:128:0x00f6 }] */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0110 A[Catch: all -> 0x010a, Exception -> 0x010d, TryCatch #19 {Exception -> 0x010d, all -> 0x010a, blocks: (B:80:0x00f6, B:82:0x00fa, B:89:0x0118, B:88:0x0110), top: B:128:0x00f6 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void z() {
        /*
            Method dump skipped, instruction units count: 370
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: X.h.z():void");
    }

    public h(ByteArrayInputStream byteArrayInputStream) {
        e[][] eVarArr = f3389V;
        this.e = new HashMap[eVarArr.length];
        this.f3411f = new HashSet(eVarArr.length);
        this.f3412g = ByteOrder.BIG_ENDIAN;
        this.f3407a = null;
        this.f3409c = null;
        this.f3408b = null;
        r(byteArrayInputStream);
    }
}
