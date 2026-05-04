.class public Ls9/b$d;
.super Lu9/e$a;
.source "r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Ls9/b;->w(Landroid/app/Activity;Lv9/c;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x1
    name = null
.end annotation


# instance fields
.field public final synthetic e:Lv9/c;

.field public final synthetic f:Landroid/app/Activity;

.field public final synthetic g:Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;

.field public final synthetic h:Ls9/b;


# direct methods
.method public constructor <init>(Ls9/b;Lv9/c;Landroid/app/Activity;Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;)V
    .locals 0

    .line 1
    iput-object p1, p0, Ls9/b$d;->h:Ls9/b;

    .line 2
    .line 3
    iput-object p2, p0, Ls9/b$d;->e:Lv9/c;

    .line 4
    .line 5
    iput-object p3, p0, Ls9/b$d;->f:Landroid/app/Activity;

    .line 6
    .line 7
    iput-object p4, p0, Ls9/b$d;->g:Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;

    .line 8
    .line 9
    invoke-direct {p0}, Lu9/e$a;-><init>()V

    .line 10
    .line 11
    .line 12
    return-void
    .line 13
    .line 14
    .line 15
    .line 16
    .line 17
    .line 18
    .line 19
    .line 20
    .line 21
    .line 22
    .line 23
    .line 24
    .line 25
    .line 26
    .line 27
    .line 28
    .line 29
    .line 30
    .line 31
    .line 32
    .line 33
    .line 34
    .line 35
    .line 36
    .line 37
    .line 38
    .line 39
    .line 40
    .line 41
    .line 42
    .line 43
    .line 44
    .line 45
    .line 46
    .line 47
    .line 48
    .line 49
    .line 50
    .line 51
    .line 52
    .line 53
    .line 54
    .line 55
    .line 56
    .line 57
    .line 58
    .line 59
    .line 60
    .line 61
    .line 62
    .line 63
    .line 64
    .line 65
    .line 66
    .line 67
    .line 68
    .line 69
    .line 70
    .line 71
    .line 72
    .line 73
    .line 74
    .line 75
    .line 76
    .line 77
    .line 78
    .line 79
    .line 80
    .line 81
    .line 82
    .line 83
    .line 84
    .line 85
    .line 86
    .line 87
    .line 88
    .line 89
    .line 90
    .line 91
    .line 92
    .line 93
    .line 94
    .line 95
    .line 96
    .line 97
    .line 98
    .line 99
    .line 100
    .line 101
    .line 102
    .line 103
    .line 104
    .line 105
    .line 106
    .line 107
    .line 108
    .line 109
    .line 110
    .line 111
    .line 112
    .line 113
    .line 114
    .line 115
    .line 116
    .line 117
    .line 118
    .line 119
    .line 120
    .line 121
    .line 122
    .line 123
    .line 124
    .line 125
    .line 126
    .line 127
    .line 128
    .line 129
    .line 130
    .line 131
    .line 132
    .line 133
    .line 134
    .line 135
    .line 136
    .line 137
    .line 138
    .line 139
    .line 140
    .line 141
    .line 142
    .line 143
    .line 144
    .line 145
    .line 146
    .line 147
    .line 148
    .line 149
    .line 150
    .line 151
    .line 152
    .line 153
    .line 154
    .line 155
    .line 156
    .line 157
    .line 158
    .line 159
    .line 160
    .line 161
    .line 162
    .line 163
    .line 164
    .line 165
    .line 166
    .line 167
    .line 168
    .line 169
    .line 170
    .line 171
    .line 172
    .line 173
    .line 174
    .line 175
    .line 176
.end method


# virtual methods
.method public l(Ljava/lang/Exception;)V
    .locals 1

    .line 1
    const-string p1, "Image download failure "

    .line 2
    .line 3
    invoke-static {p1}, Lu9/l;->e(Ljava/lang/String;)V

    .line 4
    .line 5
    .line 6
    iget-object p1, p0, Ls9/b$d;->g:Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;

    .line 7
    .line 8
    if-eqz p1, :cond_0

    .line 9
    .line 10
    iget-object p1, p0, Ls9/b$d;->e:Lv9/c;

    .line 11
    .line 12
    invoke-virtual {p1}, Lv9/c;->e()Landroid/widget/ImageView;

    .line 13
    .line 14
    .line 15
    move-result-object p1

    .line 16
    invoke-virtual {p1}, Landroid/view/View;->getViewTreeObserver()Landroid/view/ViewTreeObserver;

    .line 17
    .line 18
    .line 19
    move-result-object p1

    .line 20
    iget-object v0, p0, Ls9/b$d;->g:Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;

    .line 21
    .line 22
    invoke-virtual {p1, v0}, Landroid/view/ViewTreeObserver;->removeGlobalOnLayoutListener(Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;)V

    .line 23
    .line 24
    .line 25
    :cond_0
    iget-object p1, p0, Ls9/b$d;->h:Ls9/b;

    .line 26
    .line 27
    invoke-static {p1}, Ls9/b;->g(Ls9/b;)V

    .line 28
    .line 29
    .line 30
    iget-object p1, p0, Ls9/b$d;->h:Ls9/b;

    .line 31
    .line 32
    invoke-static {p1}, Ls9/b;->l(Ls9/b;)V

    .line 33
    .line 34
    .line 35
    return-void
    .line 36
    .line 37
    .line 38
    .line 39
    .line 40
    .line 41
    .line 42
    .line 43
    .line 44
    .line 45
    .line 46
    .line 47
    .line 48
    .line 49
    .line 50
    .line 51
    .line 52
    .line 53
    .line 54
    .line 55
    .line 56
    .line 57
    .line 58
    .line 59
    .line 60
    .line 61
    .line 62
    .line 63
    .line 64
    .line 65
    .line 66
    .line 67
    .line 68
    .line 69
    .line 70
    .line 71
.end method

.method public n()V
    .locals 7

    .line 1
    iget-object v0, p0, Ls9/b$d;->e:Lv9/c;

    .line 2
    .line 3
    invoke-virtual {v0}, Lv9/c;->b()Lu9/k;

    .line 4
    .line 5
    .line 6
    move-result-object v0

    .line 7
    invoke-virtual {v0}, Lu9/k;->p()Ljava/lang/Boolean;

    .line 8
    .line 9
    .line 10
    move-result-object v0

    .line 11
    invoke-virtual {v0}, Ljava/lang/Boolean;->booleanValue()Z

    .line 12
    .line 13
    .line 14
    move-result v0

    .line 15
    if-nez v0, :cond_0

    .line 16
    .line 17
    iget-object v0, p0, Ls9/b$d;->e:Lv9/c;

    .line 18
    .line 19
    invoke-virtual {v0}, Lv9/c;->f()Landroid/view/ViewGroup;

    .line 20
    .line 21
    .line 22
    move-result-object v0

    .line 23
    new-instance v1, Ls9/b$d$a;

    .line 24
    .line 25
    invoke-direct {v1, p0}, Ls9/b$d$a;-><init>(Ls9/b$d;)V

    .line 26
    .line 27
    .line 28
    invoke-virtual {v0, v1}, Landroid/view/View;->setOnTouchListener(Landroid/view/View$OnTouchListener;)V

    .line 29
    .line 30
    .line 31
    :cond_0
    iget-object v0, p0, Ls9/b$d;->h:Ls9/b;

    .line 32
    .line 33
    invoke-static {v0}, Ls9/b;->n(Ls9/b;)Lu9/m;

    .line 34
    .line 35
    .line 36
    move-result-object v1

    .line 37
    new-instance v2, Ls9/b$d$b;

    .line 38
    .line 39
    invoke-direct {v2, p0}, Ls9/b$d$b;-><init>(Ls9/b$d;)V

    .line 40
    .line 41
    .line 42
    const-wide/16 v3, 0x1388

    .line 43
    .line 44
    const-wide/16 v5, 0x3e8

    .line 45
    .line 46
    invoke-virtual/range {v1 .. v6}, Lu9/m;->b(Lu9/m$b;JJ)V

    .line 47
    .line 48
    .line 49
    iget-object v0, p0, Ls9/b$d;->e:Lv9/c;

    .line 50
    .line 51
    invoke-virtual {v0}, Lv9/c;->b()Lu9/k;

    .line 52
    .line 53
    .line 54
    move-result-object v0

    .line 55
    invoke-virtual {v0}, Lu9/k;->o()Ljava/lang/Boolean;

    .line 56
    .line 57
    .line 58
    move-result-object v0

    .line 59
    invoke-virtual {v0}, Ljava/lang/Boolean;->booleanValue()Z

    .line 60
    .line 61
    .line 62
    move-result v0

    .line 63
    if-eqz v0, :cond_1

    .line 64
    .line 65
    iget-object v0, p0, Ls9/b$d;->h:Ls9/b;

    .line 66
    .line 67
    invoke-static {v0}, Ls9/b;->o(Ls9/b;)Lu9/m;

    .line 68
    .line 69
    .line 70
    move-result-object v1

    .line 71
    new-instance v2, Ls9/b$d$c;

    .line 72
    .line 73
    invoke-direct {v2, p0}, Ls9/b$d$c;-><init>(Ls9/b$d;)V

    .line 74
    .line 75
    .line 76
    const-wide/16 v3, 0x4e20

    .line 77
    .line 78
    const-wide/16 v5, 0x3e8

    .line 79
    .line 80
    invoke-virtual/range {v1 .. v6}, Lu9/m;->b(Lu9/m$b;JJ)V

    .line 81
    .line 82
    .line 83
    :cond_1
    iget-object v0, p0, Ls9/b$d;->f:Landroid/app/Activity;

    .line 84
    .line 85
    new-instance v1, Ls9/b$d$d;

    .line 86
    .line 87
    invoke-direct {v1, p0}, Ls9/b$d$d;-><init>(Ls9/b$d;)V

    .line 88
    .line 89
    .line 90
    invoke-virtual {v0, v1}, Landroid/app/Activity;->runOnUiThread(Ljava/lang/Runnable;)V

    .line 91
    .line 92
    .line 93
    return-void
    .line 94
    .line 95
    .line 96
    .line 97
    .line 98
    .line 99
    .line 100
    .line 101
    .line 102
    .line 103
    .line 104
    .line 105
    .line 106
    .line 107
    .line 108
    .line 109
    .line 110
    .line 111
    .line 112
    .line 113
    .line 114
    .line 115
    .line 116
    .line 117
    .line 118
    .line 119
    .line 120
    .line 121
    .line 122
    .line 123
    .line 124
    .line 125
    .line 126
    .line 127
    .line 128
    .line 129
    .line 130
    .line 131
    .line 132
    .line 133
    .line 134
    .line 135
    .line 136
    .line 137
    .line 138
    .line 139
    .line 140
    .line 141
    .line 142
    .line 143
    .line 144
    .line 145
    .line 146
    .line 147
    .line 148
    .line 149
    .line 150
    .line 151
    .line 152
    .line 153
    .line 154
    .line 155
    .line 156
    .line 157
    .line 158
    .line 159
    .line 160
    .line 161
    .line 162
    .line 163
    .line 164
    .line 165
    .line 166
    .line 167
    .line 168
    .line 169
    .line 170
    .line 171
    .line 172
    .line 173
    .line 174
    .line 175
    .line 176
    .line 177
    .line 178
    .line 179
    .line 180
    .line 181
    .line 182
    .line 183
    .line 184
    .line 185
    .line 186
    .line 187
    .line 188
    .line 189
    .line 190
    .line 191
    .line 192
    .line 193
    .line 194
    .line 195
    .line 196
.end method
