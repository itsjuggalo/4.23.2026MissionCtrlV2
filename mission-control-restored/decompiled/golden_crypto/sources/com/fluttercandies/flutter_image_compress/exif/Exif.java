package com.fluttercandies.flutter_image_compress.exif;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.exifinterface.media.ExifInterface;
import io.flutter.plugins.firebase.crashlytics.Constants;
import java.io.ByteArrayInputStream;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Exif.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007J\u0010\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u0007H\u0002J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u000b¨\u0006\f"}, d2 = {"Lcom/fluttercandies/flutter_image_compress/exif/Exif;", "", "<init>", "()V", "getRotationDegrees", "", "_bytes", "", "getFromExifInterface", "byteArray", Constants.FILE, "Ljava/io/File;", "flutter_image_compress_common_release"}, k = 1, mv = {2, 0, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class Exif {
    public static final Exif INSTANCE = new Exif();

    private Exif() {
    }

    public final int getRotationDegrees(byte[] _bytes) {
        Intrinsics.checkNotNullParameter(_bytes, "_bytes");
        try {
            return getFromExifInterface(_bytes);
        } catch (Exception unused) {
            return 0;
        }
    }

    private final int getFromExifInterface(byte[] byteArray) {
        return new ExifInterface(new ByteArrayInputStream(byteArray)).getRotationDegrees();
    }

    public final int getRotationDegrees(File file) {
        Intrinsics.checkNotNullParameter(file, "file");
        try {
            return new ExifInterface(file.getAbsolutePath()).getRotationDegrees();
        } catch (Exception unused) {
            return 0;
        }
    }
}
