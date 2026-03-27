package com.revenuecat.purchases.utils;

import W2.m;
import X2.AbstractC0769p;
import X2.AbstractC0770q;
import X2.C0760g;
import X2.P;
import X2.Q;
import X2.S;
import X2.u;
import android.net.Uri;
import com.revenuecat.purchases.LogHandler;
import com.revenuecat.purchases.LogLevel;
import com.revenuecat.purchases.Offering;
import com.revenuecat.purchases.common.Config;
import com.revenuecat.purchases.common.LogWrapperKt;
import com.revenuecat.purchases.paywalls.PaywallData;
import com.revenuecat.purchases.paywalls.components.ButtonComponent;
import com.revenuecat.purchases.paywalls.components.CarouselComponent;
import com.revenuecat.purchases.paywalls.components.IconComponent;
import com.revenuecat.purchases.paywalls.components.ImageComponent;
import com.revenuecat.purchases.paywalls.components.PackageComponent;
import com.revenuecat.purchases.paywalls.components.PartialCarouselComponent;
import com.revenuecat.purchases.paywalls.components.PartialImageComponent;
import com.revenuecat.purchases.paywalls.components.PartialStackComponent;
import com.revenuecat.purchases.paywalls.components.PartialTabsComponent;
import com.revenuecat.purchases.paywalls.components.PaywallComponent;
import com.revenuecat.purchases.paywalls.components.PurchaseButtonComponent;
import com.revenuecat.purchases.paywalls.components.StackComponent;
import com.revenuecat.purchases.paywalls.components.StickyFooterComponent;
import com.revenuecat.purchases.paywalls.components.TabControlButtonComponent;
import com.revenuecat.purchases.paywalls.components.TabControlComponent;
import com.revenuecat.purchases.paywalls.components.TabControlToggleComponent;
import com.revenuecat.purchases.paywalls.components.TabsComponent;
import com.revenuecat.purchases.paywalls.components.TextComponent;
import com.revenuecat.purchases.paywalls.components.TimelineComponent;
import com.revenuecat.purchases.paywalls.components.common.Background;
import com.revenuecat.purchases.paywalls.components.common.ComponentOverride;
import com.revenuecat.purchases.paywalls.components.common.PaywallComponentsConfig;
import com.revenuecat.purchases.paywalls.components.properties.ImageUrls;
import com.revenuecat.purchases.paywalls.components.properties.ThemeImageUrls;
import i3.k;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.jvm.internal.AbstractC1585j;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.s;

/* JADX INFO: loaded from: classes3.dex */
public final class OfferingImagePreDownloader {
    private final CoilImageDownloader coilImageDownloader;
    private final boolean shouldPredownloadImages;

    /* JADX INFO: renamed from: com.revenuecat.purchases.utils.OfferingImagePreDownloader$findImageUrisToDownload$1, reason: invalid class name */
    public static final class AnonymousClass1 extends s implements k {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        public AnonymousClass1() {
            super(1);
        }

        @Override // i3.k
        public final Boolean invoke(PaywallComponent it) {
            r.f(it, "it");
            return Boolean.valueOf((it instanceof StackComponent) || (it instanceof IconComponent) || (it instanceof CarouselComponent) || (it instanceof TabsComponent) || (it instanceof ImageComponent));
        }
    }

    public OfferingImagePreDownloader(boolean z4, CoilImageDownloader coilImageDownloader) {
        r.f(coilImageDownloader, "coilImageDownloader");
        this.shouldPredownloadImages = z4;
        this.coilImageDownloader = coilImageDownloader;
    }

    private final void downloadV1Images(Offering offering) {
        PaywallData paywall = offering.getPaywall();
        if (paywall != null) {
            List<String> all$purchases_defaultsRelease = paywall.getConfig().getImages().getAll$purchases_defaultsRelease();
            ArrayList<Uri> arrayList = new ArrayList(AbstractC0770q.q(all$purchases_defaultsRelease, 10));
            Iterator<T> it = all$purchases_defaultsRelease.iterator();
            while (it.hasNext()) {
                arrayList.add(Uri.parse(paywall.getAssetBaseURL().toString()).buildUpon().path((String) it.next()).build());
            }
            for (Uri it2 : arrayList) {
                LogLevel logLevel = LogLevel.DEBUG;
                LogHandler currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                    currentLogHandler.d("[Purchases] - " + logLevel.name(), "Pre-downloading Paywall V1 image: " + it2);
                }
                CoilImageDownloader coilImageDownloader = this.coilImageDownloader;
                r.e(it2, "it");
                coilImageDownloader.downloadImage(it2);
            }
        }
    }

    private final void downloadV2Images(Offering offering) {
        Offering.PaywallComponents paywallComponents = offering.getPaywallComponents();
        if (paywallComponents != null) {
            for (Uri uri : findImageUrisToDownload(paywallComponents)) {
                LogLevel logLevel = LogLevel.DEBUG;
                LogHandler currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                    currentLogHandler.d("[Purchases] - " + logLevel.name(), "Pre-downloading Paywall V2 image: " + uri);
                }
                this.coilImageDownloader.downloadImage(uri);
            }
        }
    }

    private final List<PaywallComponent> filter(PaywallComponent paywallComponent, k kVar) {
        ArrayList arrayList = new ArrayList();
        C0760g c0760g = new C0760g();
        c0760g.add(paywallComponent);
        while (!c0760g.isEmpty()) {
            PaywallComponent paywallComponent2 = (PaywallComponent) c0760g.removeFirst();
            if (((Boolean) kVar.invoke(paywallComponent2)).booleanValue()) {
                arrayList.add(paywallComponent2);
            }
            if (paywallComponent2 instanceof StackComponent) {
                c0760g.addAll(((StackComponent) paywallComponent2).getComponents());
            } else if (paywallComponent2 instanceof PurchaseButtonComponent) {
                c0760g.add(((PurchaseButtonComponent) paywallComponent2).getStack());
            } else if (paywallComponent2 instanceof ButtonComponent) {
                c0760g.add(((ButtonComponent) paywallComponent2).getStack());
            } else if (paywallComponent2 instanceof PackageComponent) {
                c0760g.add(((PackageComponent) paywallComponent2).getStack());
            } else if (paywallComponent2 instanceof StickyFooterComponent) {
                c0760g.add(((StickyFooterComponent) paywallComponent2).getStack());
            } else if (paywallComponent2 instanceof CarouselComponent) {
                c0760g.addAll(((CarouselComponent) paywallComponent2).getPages());
            } else if (paywallComponent2 instanceof TabControlButtonComponent) {
                c0760g.add(((TabControlButtonComponent) paywallComponent2).getStack());
            } else if (paywallComponent2 instanceof TabsComponent) {
                TabsComponent tabsComponent = (TabsComponent) paywallComponent2;
                TabsComponent.TabControl control = tabsComponent.getControl();
                if (control instanceof TabsComponent.TabControl.Buttons) {
                    c0760g.add(((TabsComponent.TabControl.Buttons) control).getStack());
                } else if (control instanceof TabsComponent.TabControl.Toggle) {
                    c0760g.add(((TabsComponent.TabControl.Toggle) control).getStack());
                }
                List tabs = tabsComponent.getTabs();
                ArrayList arrayList2 = new ArrayList(AbstractC0770q.q(tabs, 10));
                Iterator it = tabs.iterator();
                while (it.hasNext()) {
                    arrayList2.add(((TabsComponent.Tab) it.next()).getStack());
                }
                c0760g.addAll(arrayList2);
            } else if (paywallComponent2 instanceof TimelineComponent) {
                List<TimelineComponent.Item> items = ((TimelineComponent) paywallComponent2).getItems();
                ArrayList arrayList3 = new ArrayList();
                for (TimelineComponent.Item item : items) {
                    u.t(arrayList3, AbstractC0769p.l(item.getTitle(), item.getDescription(), item.getIcon()));
                }
                c0760g.addAll(arrayList3);
            } else if (!(paywallComponent2 instanceof TabControlToggleComponent ? true : paywallComponent2 instanceof TabControlComponent ? true : paywallComponent2 instanceof ImageComponent ? true : paywallComponent2 instanceof IconComponent)) {
                boolean z4 = paywallComponent2 instanceof TextComponent;
            }
        }
        return arrayList;
    }

    private final Set<Uri> findImageUrisToDownload(Offering.PaywallComponents paywallComponents) {
        StackComponent stack;
        PaywallComponentsConfig base = paywallComponents.getData().getComponentsConfig().getBase();
        Set<Uri> setFindImageUrisToDownload = findImageUrisToDownload(base.getStack());
        StickyFooterComponent stickyFooter = base.getStickyFooter();
        Set<Uri> setFindImageUrisToDownload2 = (stickyFooter == null || (stack = stickyFooter.getStack()) == null) ? null : findImageUrisToDownload(stack);
        if (setFindImageUrisToDownload2 == null) {
            setFindImageUrisToDownload2 = Q.b();
        }
        return S.h(S.h(setFindImageUrisToDownload, setFindImageUrisToDownload2), findImageUrisToDownload(base.getBackground()));
    }

    public final void preDownloadOfferingImages(Offering offering) {
        r.f(offering, "offering");
        if (!this.shouldPredownloadImages) {
            LogLevel logLevel = LogLevel.VERBOSE;
            LogHandler currentLogHandler = LogWrapperKt.getCurrentLogHandler();
            if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                currentLogHandler.v("[Purchases] - " + logLevel.name(), "OfferingImagePreDownloader won't pre-download images");
                return;
            }
            return;
        }
        LogLevel logLevel2 = LogLevel.DEBUG;
        LogHandler currentLogHandler2 = LogWrapperKt.getCurrentLogHandler();
        if (Config.INSTANCE.getLogLevel().compareTo(logLevel2) <= 0) {
            currentLogHandler2.d("[Purchases] - " + logLevel2.name(), "OfferingImagePreDownloader: starting image download");
        }
        downloadV1Images(offering);
        downloadV2Images(offering);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ OfferingImagePreDownloader(boolean z4, CoilImageDownloader coilImageDownloader, int i4, AbstractC1585j abstractC1585j) {
        if ((i4 & 1) != 0) {
            try {
                Class.forName("com.revenuecat.purchases.ui.revenuecatui.PaywallKt");
                z4 = true;
            } catch (ClassNotFoundException unused) {
                z4 = false;
            }
        }
        this(z4, coilImageDownloader);
    }

    private final Set<Uri> findImageUrisToDownload(StackComponent stackComponent) {
        Set setB;
        List<PaywallComponent> listFilter = filter(stackComponent, AnonymousClass1.INSTANCE);
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (PaywallComponent paywallComponent : listFilter) {
            if (paywallComponent instanceof StackComponent) {
                StackComponent stackComponent2 = (StackComponent) paywallComponent;
                Set<Uri> setFindImageUrisToDownload = findImageUrisToDownload(stackComponent2.getBackground());
                List overrides = stackComponent2.getOverrides();
                LinkedHashSet linkedHashSet2 = new LinkedHashSet();
                Iterator it = overrides.iterator();
                while (it.hasNext()) {
                    u.t(linkedHashSet2, findImageUrisToDownload(((PartialStackComponent) ((ComponentOverride) it.next()).getProperties()).getBackground()));
                }
                setB = S.h(setFindImageUrisToDownload, linkedHashSet2);
            } else if (paywallComponent instanceof IconComponent) {
                IconComponent iconComponent = (IconComponent) paywallComponent;
                setB = P.a(Uri.parse(iconComponent.getBaseUrl()).buildUpon().path(iconComponent.getFormats().getWebp()).build());
            } else if (paywallComponent instanceof CarouselComponent) {
                CarouselComponent carouselComponent = (CarouselComponent) paywallComponent;
                Set<Uri> setFindImageUrisToDownload2 = findImageUrisToDownload(carouselComponent.getBackground());
                List overrides2 = carouselComponent.getOverrides();
                LinkedHashSet linkedHashSet3 = new LinkedHashSet();
                Iterator it2 = overrides2.iterator();
                while (it2.hasNext()) {
                    u.t(linkedHashSet3, findImageUrisToDownload(((PartialCarouselComponent) ((ComponentOverride) it2.next()).getProperties()).getBackground()));
                }
                setB = S.h(setFindImageUrisToDownload2, linkedHashSet3);
            } else if (paywallComponent instanceof TabsComponent) {
                TabsComponent tabsComponent = (TabsComponent) paywallComponent;
                Set<Uri> setFindImageUrisToDownload3 = findImageUrisToDownload(tabsComponent.getBackground());
                List overrides3 = tabsComponent.getOverrides();
                LinkedHashSet linkedHashSet4 = new LinkedHashSet();
                Iterator it3 = overrides3.iterator();
                while (it3.hasNext()) {
                    u.t(linkedHashSet4, findImageUrisToDownload(((PartialTabsComponent) ((ComponentOverride) it3.next()).getProperties()).getBackground()));
                }
                setB = S.h(setFindImageUrisToDownload3, linkedHashSet4);
            } else if (paywallComponent instanceof ImageComponent) {
                ImageComponent imageComponent = (ImageComponent) paywallComponent;
                Set<Uri> setFindImageUrisToDownload4 = findImageUrisToDownload(imageComponent.getSource());
                List overrides4 = imageComponent.getOverrides();
                LinkedHashSet linkedHashSet5 = new LinkedHashSet();
                Iterator it4 = overrides4.iterator();
                while (it4.hasNext()) {
                    ThemeImageUrls source = ((PartialImageComponent) ((ComponentOverride) it4.next()).getProperties()).getSource();
                    Set<Uri> setFindImageUrisToDownload5 = source != null ? findImageUrisToDownload(source) : null;
                    if (setFindImageUrisToDownload5 == null) {
                        setFindImageUrisToDownload5 = Q.b();
                    }
                    u.t(linkedHashSet5, setFindImageUrisToDownload5);
                }
                setB = S.h(setFindImageUrisToDownload4, linkedHashSet5);
            } else {
                setB = Q.b();
            }
            u.t(linkedHashSet, setB);
        }
        return linkedHashSet;
    }

    private final Set<Uri> findImageUrisToDownload(Background background) {
        URL webpLowRes;
        String string;
        if (background instanceof Background.Image) {
            Background.Image image = (Background.Image) background;
            Uri uri = Uri.parse(image.getValue().getLight().getWebpLowRes().toString());
            ImageUrls dark = image.getValue().getDark();
            return Q.f(uri, (dark == null || (webpLowRes = dark.getWebpLowRes()) == null || (string = webpLowRes.toString()) == null) ? null : Uri.parse(string));
        }
        boolean z4 = true;
        if (!(background instanceof Background.Color ? true : background instanceof Background.Unknown) && background != null) {
            z4 = false;
        }
        if (z4) {
            return Q.b();
        }
        throw new m();
    }

    private final Set<Uri> findImageUrisToDownload(ThemeImageUrls themeImageUrls) {
        URL webpLowRes;
        String string;
        Uri uri = Uri.parse(themeImageUrls.getLight().getWebpLowRes().toString());
        ImageUrls dark = themeImageUrls.getDark();
        return Q.f(uri, (dark == null || (webpLowRes = dark.getWebpLowRes()) == null || (string = webpLowRes.toString()) == null) ? null : Uri.parse(string));
    }
}
