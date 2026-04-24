package io.flutter.plugin.editing;

import U4.x;
import V4.j;
import android.view.textservice.SentenceSuggestionsInfo;
import android.view.textservice.SpellCheckerSession;
import android.view.textservice.SuggestionsInfo;
import android.view.textservice.TextInfo;
import android.view.textservice.TextServicesManager;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;

/* JADX INFO: loaded from: classes2.dex */
public class r implements x.b, SpellCheckerSession.SpellCheckerSessionListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final U4.x f16678a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TextServicesManager f16679b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public SpellCheckerSession f16680c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public j.d f16681d;

    public r(TextServicesManager textServicesManager, U4.x xVar) {
        this.f16679b = textServicesManager;
        this.f16678a = xVar;
        xVar.b(this);
    }

    @Override // U4.x.b
    public void a(String str, String str2, j.d dVar) {
        if (this.f16681d != null) {
            dVar.b("error", "Previous spell check request still pending.", null);
        } else {
            this.f16681d = dVar;
            c(str, str2);
        }
    }

    public void b() {
        this.f16678a.b(null);
        SpellCheckerSession spellCheckerSession = this.f16680c;
        if (spellCheckerSession != null) {
            spellCheckerSession.close();
        }
    }

    public void c(String str, String str2) {
        Locale localeB = W4.d.b(str);
        if (this.f16680c == null) {
            this.f16680c = this.f16679b.newSpellCheckerSession(null, localeB, this, true);
        }
        this.f16680c.getSentenceSuggestions(new TextInfo[]{new TextInfo(str2)}, 5);
    }

    @Override // android.view.textservice.SpellCheckerSession.SpellCheckerSessionListener
    public void onGetSentenceSuggestions(SentenceSuggestionsInfo[] sentenceSuggestionsInfoArr) {
        if (sentenceSuggestionsInfoArr.length == 0) {
            this.f16681d.a(new ArrayList());
            this.f16681d = null;
            return;
        }
        ArrayList arrayList = new ArrayList();
        SentenceSuggestionsInfo sentenceSuggestionsInfo = sentenceSuggestionsInfoArr[0];
        if (sentenceSuggestionsInfo == null) {
            this.f16681d.a(new ArrayList());
            this.f16681d = null;
            return;
        }
        for (int i7 = 0; i7 < sentenceSuggestionsInfo.getSuggestionsCount(); i7++) {
            SuggestionsInfo suggestionsInfoAt = sentenceSuggestionsInfo.getSuggestionsInfoAt(i7);
            int suggestionsCount = suggestionsInfoAt.getSuggestionsCount();
            if (suggestionsCount > 0) {
                HashMap map = new HashMap();
                int offsetAt = sentenceSuggestionsInfo.getOffsetAt(i7);
                int lengthAt = sentenceSuggestionsInfo.getLengthAt(i7) + offsetAt;
                map.put("startIndex", Integer.valueOf(offsetAt));
                map.put("endIndex", Integer.valueOf(lengthAt));
                ArrayList arrayList2 = new ArrayList();
                boolean z7 = false;
                for (int i8 = 0; i8 < suggestionsCount; i8++) {
                    String suggestionAt = suggestionsInfoAt.getSuggestionAt(i8);
                    if (!suggestionAt.equals("")) {
                        arrayList2.add(suggestionAt);
                        z7 = true;
                    }
                }
                if (z7) {
                    map.put("suggestions", arrayList2);
                    arrayList.add(map);
                }
            }
        }
        this.f16681d.a(arrayList);
        this.f16681d = null;
    }

    @Override // android.view.textservice.SpellCheckerSession.SpellCheckerSessionListener
    public void onGetSuggestions(SuggestionsInfo[] suggestionsInfoArr) {
    }
}
