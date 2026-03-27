package I;

import H.d;
import N.g;
import android.content.ContentResolver;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.fonts.Font;
import android.graphics.fonts.FontFamily;
import android.graphics.fonts.FontStyle;
import android.os.CancellationSignal;
import android.os.ParcelFileDescriptor;
import com.revenuecat.purchases.common.networking.RCHTTPStatusCodes;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public class i extends j {
    public static int i(FontStyle fontStyle, FontStyle fontStyle2) {
        return (Math.abs(fontStyle.getWeight() - fontStyle2.getWeight()) / 100) + (fontStyle.getSlant() == fontStyle2.getSlant() ? 0 : 2);
    }

    @Override // I.j
    public Typeface a(Context context, d.c cVar, Resources resources, int i7) {
        try {
            FontFamily.Builder builder = null;
            for (d.C0021d c0021d : cVar.a()) {
                try {
                    Font fontBuild = new Font.Builder(resources, c0021d.b()).setWeight(c0021d.e()).setSlant(c0021d.f() ? 1 : 0).setTtcIndex(c0021d.c()).setFontVariationSettings(c0021d.d()).build();
                    if (builder == null) {
                        builder = new FontFamily.Builder(fontBuild);
                    } else {
                        builder.addFont(fontBuild);
                    }
                } catch (IOException unused) {
                }
            }
            if (builder == null) {
                return null;
            }
            FontFamily fontFamilyBuild = builder.build();
            return new Typeface.CustomFallbackBuilder(fontFamilyBuild).setStyle(h(fontFamilyBuild, i7).getStyle()).build();
        } catch (Exception unused2) {
            return null;
        }
    }

    @Override // I.j
    public Typeface b(Context context, CancellationSignal cancellationSignal, g.b[] bVarArr, int i7) {
        ParcelFileDescriptor parcelFileDescriptorOpenFileDescriptor;
        ContentResolver contentResolver = context.getContentResolver();
        try {
            FontFamily.Builder builder = null;
            for (g.b bVar : bVarArr) {
                try {
                    parcelFileDescriptorOpenFileDescriptor = contentResolver.openFileDescriptor(bVar.d(), "r", cancellationSignal);
                } catch (IOException unused) {
                }
                if (parcelFileDescriptorOpenFileDescriptor == null) {
                    if (parcelFileDescriptorOpenFileDescriptor != null) {
                    }
                } else {
                    try {
                        Font fontBuild = new Font.Builder(parcelFileDescriptorOpenFileDescriptor).setWeight(bVar.e()).setSlant(bVar.f() ? 1 : 0).setTtcIndex(bVar.c()).build();
                        if (builder == null) {
                            builder = new FontFamily.Builder(fontBuild);
                        } else {
                            builder.addFont(fontBuild);
                        }
                    } catch (Throwable th) {
                        try {
                            parcelFileDescriptorOpenFileDescriptor.close();
                        } catch (Throwable th2) {
                            th.addSuppressed(th2);
                        }
                        throw th;
                    }
                }
                parcelFileDescriptorOpenFileDescriptor.close();
            }
            if (builder == null) {
                return null;
            }
            FontFamily fontFamilyBuild = builder.build();
            return new Typeface.CustomFallbackBuilder(fontFamilyBuild).setStyle(h(fontFamilyBuild, i7).getStyle()).build();
        } catch (Exception unused2) {
            return null;
        }
    }

    @Override // I.j
    public Typeface d(Context context, Resources resources, int i7, String str, int i8) {
        try {
            Font fontBuild = new Font.Builder(resources, i7).build();
            return new Typeface.CustomFallbackBuilder(new FontFamily.Builder(fontBuild).build()).setStyle(fontBuild.getStyle()).build();
        } catch (Exception unused) {
            return null;
        }
    }

    @Override // I.j
    public g.b g(g.b[] bVarArr, int i7) {
        throw new RuntimeException("Do not use this function in API 29 or later.");
    }

    public final Font h(FontFamily fontFamily, int i7) {
        FontStyle fontStyle = new FontStyle((i7 & 1) != 0 ? 700 : RCHTTPStatusCodes.BAD_REQUEST, (i7 & 2) != 0 ? 1 : 0);
        Font font = fontFamily.getFont(0);
        int i8 = i(fontStyle, font.getStyle());
        for (int i9 = 1; i9 < fontFamily.getSize(); i9++) {
            Font font2 = fontFamily.getFont(i9);
            int i10 = i(fontStyle, font2.getStyle());
            if (i10 < i8) {
                font = font2;
                i8 = i10;
            }
        }
        return font;
    }
}
