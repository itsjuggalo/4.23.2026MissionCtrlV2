package com.revenuecat.purchases.common;

import F5.AbstractC0555m;
import F5.AbstractC0556n;
import com.revenuecat.purchases.strings.Emojis;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public enum LogIntent {
    DEBUG(AbstractC0555m.b(Emojis.INFO)),
    GOOGLE_ERROR(AbstractC0556n.j(Emojis.ROBOT, Emojis.DOUBLE_EXCLAMATION)),
    GOOGLE_WARNING(AbstractC0556n.j(Emojis.ROBOT, Emojis.DOUBLE_EXCLAMATION)),
    INFO(AbstractC0555m.b(Emojis.INFO)),
    PURCHASE(AbstractC0555m.b(Emojis.MONEY_BAG)),
    RC_ERROR(AbstractC0556n.j(Emojis.SAD_CAT_EYES, Emojis.DOUBLE_EXCLAMATION)),
    RC_PURCHASE_SUCCESS(AbstractC0556n.j(Emojis.HEART_CAT_EYES, Emojis.MONEY_BAG)),
    RC_SUCCESS(AbstractC0555m.b(Emojis.HEART_CAT_EYES)),
    USER(AbstractC0555m.b(Emojis.PERSON)),
    WARNING(AbstractC0555m.b(Emojis.WARNING)),
    AMAZON_WARNING(AbstractC0556n.j(Emojis.BOX, Emojis.DOUBLE_EXCLAMATION)),
    AMAZON_ERROR(AbstractC0556n.j(Emojis.BOX, Emojis.DOUBLE_EXCLAMATION));

    private final List<String> emojiList;

    LogIntent(List list) {
        this.emojiList = list;
    }

    public final List<String> getEmojiList() {
        return this.emojiList;
    }
}
