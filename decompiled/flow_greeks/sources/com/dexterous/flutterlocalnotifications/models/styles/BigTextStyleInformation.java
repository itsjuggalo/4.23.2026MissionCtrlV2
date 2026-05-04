package com.dexterous.flutterlocalnotifications.models.styles;

import androidx.annotation.Keep;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
@Keep
public class BigTextStyleInformation extends DefaultStyleInformation {
    public String bigText;
    public String contentTitle;
    public Boolean htmlFormatBigText;
    public Boolean htmlFormatContentTitle;
    public Boolean htmlFormatSummaryText;
    public String summaryText;

    public BigTextStyleInformation(Boolean bool, Boolean bool2, String str, Boolean bool3, String str2, Boolean bool4, String str3, Boolean bool5) {
        super(bool, bool2);
        this.bigText = str;
        this.htmlFormatBigText = bool3;
        this.contentTitle = str2;
        this.htmlFormatContentTitle = bool4;
        this.summaryText = str3;
        this.htmlFormatSummaryText = bool5;
    }
}
