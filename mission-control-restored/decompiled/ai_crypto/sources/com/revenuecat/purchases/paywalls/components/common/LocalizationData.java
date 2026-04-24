package com.revenuecat.purchases.paywalls.components.common;

import com.revenuecat.purchases.InternalRevenueCatAPI;
import com.revenuecat.purchases.paywalls.components.properties.ThemeImageUrls;
import kotlin.jvm.internal.AbstractC2148j;
import kotlin.jvm.internal.r;
import n6.b;

/* JADX INFO: loaded from: classes2.dex */
@InternalRevenueCatAPI
public interface LocalizationData {
    public static final Companion Companion = Companion.$$INSTANCE;

    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        private Companion() {
        }

        public final b serializer() {
            return LocalizationDataSerializer.INSTANCE;
        }
    }

    public static final class Image implements LocalizationData {
        public static final Companion Companion = new Companion(null);
        private final ThemeImageUrls value;

        public static final class Companion {
            public /* synthetic */ Companion(AbstractC2148j abstractC2148j) {
                this();
            }

            public final b serializer() {
                return LocalizationData$Image$$serializer.INSTANCE;
            }

            private Companion() {
            }
        }

        private /* synthetic */ Image(ThemeImageUrls themeImageUrls) {
            this.value = themeImageUrls;
        }

        /* JADX INFO: renamed from: box-impl, reason: not valid java name */
        public static final /* synthetic */ Image m142boximpl(ThemeImageUrls themeImageUrls) {
            return new Image(themeImageUrls);
        }

        /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
        public static ThemeImageUrls m143constructorimpl(ThemeImageUrls value) {
            r.f(value, "value");
            return value;
        }

        /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
        public static boolean m144equalsimpl(ThemeImageUrls themeImageUrls, Object obj) {
            return (obj instanceof Image) && r.b(themeImageUrls, ((Image) obj).m148unboximpl());
        }

        /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
        public static final boolean m145equalsimpl0(ThemeImageUrls themeImageUrls, ThemeImageUrls themeImageUrls2) {
            return r.b(themeImageUrls, themeImageUrls2);
        }

        /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
        public static int m146hashCodeimpl(ThemeImageUrls themeImageUrls) {
            return themeImageUrls.hashCode();
        }

        /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
        public static String m147toStringimpl(ThemeImageUrls themeImageUrls) {
            return "Image(value=" + themeImageUrls + ')';
        }

        public boolean equals(Object obj) {
            return m144equalsimpl(this.value, obj);
        }

        public final /* synthetic */ ThemeImageUrls getValue() {
            return this.value;
        }

        public int hashCode() {
            return m146hashCodeimpl(this.value);
        }

        public String toString() {
            return m147toStringimpl(this.value);
        }

        /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
        public final /* synthetic */ ThemeImageUrls m148unboximpl() {
            return this.value;
        }
    }

    public static final class Text implements LocalizationData {
        public static final Companion Companion = new Companion(null);
        private final String value;

        public static final class Companion {
            public /* synthetic */ Companion(AbstractC2148j abstractC2148j) {
                this();
            }

            public final b serializer() {
                return LocalizationData$Text$$serializer.INSTANCE;
            }

            private Companion() {
            }
        }

        private /* synthetic */ Text(String str) {
            this.value = str;
        }

        /* JADX INFO: renamed from: box-impl, reason: not valid java name */
        public static final /* synthetic */ Text m151boximpl(String str) {
            return new Text(str);
        }

        /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
        public static String m152constructorimpl(String value) {
            r.f(value, "value");
            return value;
        }

        /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
        public static boolean m153equalsimpl(String str, Object obj) {
            return (obj instanceof Text) && r.b(str, ((Text) obj).m157unboximpl());
        }

        /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
        public static final boolean m154equalsimpl0(String str, String str2) {
            return r.b(str, str2);
        }

        /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
        public static int m155hashCodeimpl(String str) {
            return str.hashCode();
        }

        /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
        public static String m156toStringimpl(String str) {
            return "Text(value=" + str + ')';
        }

        public boolean equals(Object obj) {
            return m153equalsimpl(this.value, obj);
        }

        public final /* synthetic */ String getValue() {
            return this.value;
        }

        public int hashCode() {
            return m155hashCodeimpl(this.value);
        }

        public String toString() {
            return m156toStringimpl(this.value);
        }

        /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
        public final /* synthetic */ String m157unboximpl() {
            return this.value;
        }
    }
}
