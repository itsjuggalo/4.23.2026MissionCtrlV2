package com.revenuecat.purchases.paywalls.components.common;

import F3.b;
import com.revenuecat.purchases.InternalRevenueCatAPI;
import com.revenuecat.purchases.paywalls.components.properties.ThemeImageUrls;
import kotlin.jvm.internal.AbstractC1585j;
import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes3.dex */
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
            public /* synthetic */ Companion(AbstractC1585j abstractC1585j) {
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
        public static final /* synthetic */ Image m175boximpl(ThemeImageUrls themeImageUrls) {
            return new Image(themeImageUrls);
        }

        /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
        public static ThemeImageUrls m176constructorimpl(ThemeImageUrls value) {
            r.f(value, "value");
            return value;
        }

        /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
        public static boolean m177equalsimpl(ThemeImageUrls themeImageUrls, Object obj) {
            return (obj instanceof Image) && r.b(themeImageUrls, ((Image) obj).m181unboximpl());
        }

        /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
        public static final boolean m178equalsimpl0(ThemeImageUrls themeImageUrls, ThemeImageUrls themeImageUrls2) {
            return r.b(themeImageUrls, themeImageUrls2);
        }

        /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
        public static int m179hashCodeimpl(ThemeImageUrls themeImageUrls) {
            return themeImageUrls.hashCode();
        }

        /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
        public static String m180toStringimpl(ThemeImageUrls themeImageUrls) {
            return "Image(value=" + themeImageUrls + ')';
        }

        public boolean equals(Object obj) {
            return m177equalsimpl(this.value, obj);
        }

        public final /* synthetic */ ThemeImageUrls getValue() {
            return this.value;
        }

        public int hashCode() {
            return m179hashCodeimpl(this.value);
        }

        public String toString() {
            return m180toStringimpl(this.value);
        }

        /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
        public final /* synthetic */ ThemeImageUrls m181unboximpl() {
            return this.value;
        }
    }

    public static final class Text implements LocalizationData {
        public static final Companion Companion = new Companion(null);
        private final String value;

        public static final class Companion {
            public /* synthetic */ Companion(AbstractC1585j abstractC1585j) {
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
        public static final /* synthetic */ Text m184boximpl(String str) {
            return new Text(str);
        }

        /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
        public static String m185constructorimpl(String value) {
            r.f(value, "value");
            return value;
        }

        /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
        public static boolean m186equalsimpl(String str, Object obj) {
            return (obj instanceof Text) && r.b(str, ((Text) obj).m190unboximpl());
        }

        /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
        public static final boolean m187equalsimpl0(String str, String str2) {
            return r.b(str, str2);
        }

        /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
        public static int m188hashCodeimpl(String str) {
            return str.hashCode();
        }

        /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
        public static String m189toStringimpl(String str) {
            return "Text(value=" + str + ')';
        }

        public boolean equals(Object obj) {
            return m186equalsimpl(this.value, obj);
        }

        public final /* synthetic */ String getValue() {
            return this.value;
        }

        public int hashCode() {
            return m188hashCodeimpl(this.value);
        }

        public String toString() {
            return m189toStringimpl(this.value);
        }

        /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
        public final /* synthetic */ String m190unboximpl() {
            return this.value;
        }
    }
}
