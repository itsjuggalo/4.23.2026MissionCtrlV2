.class public final Lw9/d$c;
.super Ljava/lang/Object;
.source "r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7"

# interfaces
.implements Lw9/f;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lw9/d;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x19
    name = "c"
.end annotation


# instance fields
.field public final a:Lx9/g;

.field public final b:Lw9/d$c;

.field public c:Lt9/e;

.field public d:Lt9/e;

.field public e:Lt9/e;

.field public f:Lt9/e;

.field public g:Lt9/e;

.field public h:Lt9/e;

.field public i:Lt9/e;

.field public j:Lt9/e;

.field public k:Lt9/e;

.field public l:Lt9/e;

.field public m:Lt9/e;

.field public n:Lt9/e;


# direct methods
.method public constructor <init>(Lx9/a;Lx9/g;)V
    .locals 0

    .line 2
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 3
    iput-object p0, p0, Lw9/d$c;->b:Lw9/d$c;

    .line 4
    iput-object p2, p0, Lw9/d$c;->a:Lx9/g;

    .line 5
    invoke-virtual {p0, p1, p2}, Lw9/d$c;->e(Lx9/a;Lx9/g;)V

    return-void
.end method

.method public synthetic constructor <init>(Lx9/a;Lx9/g;Lw9/d$a;)V
    .locals 0

    .line 1
    invoke-direct {p0, p1, p2}, Lw9/d$c;-><init>(Lx9/a;Lx9/g;)V

    return-void
.end method


# virtual methods
.method public a()Lu9/g;
    .locals 1

    .line 1
    iget-object v0, p0, Lw9/d$c;->d:Lt9/e;

    .line 2
    .line 3
    invoke-interface {v0}, Lbd/a;->get()Ljava/lang/Object;

    .line 4
    .line 5
    .line 6
    move-result-object v0

    .line 7
    check-cast v0, Lu9/g;

    .line 8
    .line 9
    return-object v0
    .line 10
    .line 11
    .line 12
    .line 13
    .line 14
    .line 15
    .line 16
.end method

.method public b()Landroid/app/Application;
    .locals 1

    .line 1
    iget-object v0, p0, Lw9/d$c;->c:Lt9/e;

    .line 2
    .line 3
    invoke-interface {v0}, Lbd/a;->get()Ljava/lang/Object;

    .line 4
    .line 5
    .line 6
    move-result-object v0

    .line 7
    check-cast v0, Landroid/app/Application;

    .line 8
    .line 9
    return-object v0
    .line 10
    .line 11
    .line 12
    .line 13
    .line 14
    .line 15
    .line 16
.end method

.method public c()Ljava/util/Map;
    .locals 3

    .line 1
    const/16 v0, 0x8

    .line 2
    .line 3
    invoke-static {v0}, Lt9/c;->b(I)Lt9/c;

    .line 4
    .line 5
    .line 6
    move-result-object v0

    .line 7
    const-string v1, "IMAGE_ONLY_PORTRAIT"

    .line 8
    .line 9
    iget-object v2, p0, Lw9/d$c;->g:Lt9/e;

    .line 10
    .line 11
    invoke-virtual {v0, v1, v2}, Lt9/c;->c(Ljava/lang/Object;Ljava/lang/Object;)Lt9/c;

    .line 12
    .line 13
    .line 14
    move-result-object v0

    .line 15
    const-string v1, "IMAGE_ONLY_LANDSCAPE"

    .line 16
    .line 17
    iget-object v2, p0, Lw9/d$c;->h:Lt9/e;

    .line 18
    .line 19
    invoke-virtual {v0, v1, v2}, Lt9/c;->c(Ljava/lang/Object;Ljava/lang/Object;)Lt9/c;

    .line 20
    .line 21
    .line 22
    move-result-object v0

    .line 23
    const-string v1, "MODAL_LANDSCAPE"

    .line 24
    .line 25
    iget-object v2, p0, Lw9/d$c;->i:Lt9/e;

    .line 26
    .line 27
    invoke-virtual {v0, v1, v2}, Lt9/c;->c(Ljava/lang/Object;Ljava/lang/Object;)Lt9/c;

    .line 28
    .line 29
    .line 30
    move-result-object v0

    .line 31
    const-string v1, "MODAL_PORTRAIT"

    .line 32
    .line 33
    iget-object v2, p0, Lw9/d$c;->j:Lt9/e;

    .line 34
    .line 35
    invoke-virtual {v0, v1, v2}, Lt9/c;->c(Ljava/lang/Object;Ljava/lang/Object;)Lt9/c;

    .line 36
    .line 37
    .line 38
    move-result-object v0

    .line 39
    const-string v1, "CARD_LANDSCAPE"

    .line 40
    .line 41
    iget-object v2, p0, Lw9/d$c;->k:Lt9/e;

    .line 42
    .line 43
    invoke-virtual {v0, v1, v2}, Lt9/c;->c(Ljava/lang/Object;Ljava/lang/Object;)Lt9/c;

    .line 44
    .line 45
    .line 46
    move-result-object v0

    .line 47
    const-string v1, "CARD_PORTRAIT"

    .line 48
    .line 49
    iget-object v2, p0, Lw9/d$c;->l:Lt9/e;

    .line 50
    .line 51
    invoke-virtual {v0, v1, v2}, Lt9/c;->c(Ljava/lang/Object;Ljava/lang/Object;)Lt9/c;

    .line 52
    .line 53
    .line 54
    move-result-object v0

    .line 55
    const-string v1, "BANNER_PORTRAIT"

    .line 56
    .line 57
    iget-object v2, p0, Lw9/d$c;->m:Lt9/e;

    .line 58
    .line 59
    invoke-virtual {v0, v1, v2}, Lt9/c;->c(Ljava/lang/Object;Ljava/lang/Object;)Lt9/c;

    .line 60
    .line 61
    .line 62
    move-result-object v0

    .line 63
    const-string v1, "BANNER_LANDSCAPE"

    .line 64
    .line 65
    iget-object v2, p0, Lw9/d$c;->n:Lt9/e;

    .line 66
    .line 67
    invoke-virtual {v0, v1, v2}, Lt9/c;->c(Ljava/lang/Object;Ljava/lang/Object;)Lt9/c;

    .line 68
    .line 69
    .line 70
    move-result-object v0

    .line 71
    invoke-virtual {v0}, Lt9/c;->a()Ljava/util/Map;

    .line 72
    .line 73
    .line 74
    move-result-object v0

    .line 75
    return-object v0
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

.method public d()Lu9/a;
    .locals 1

    .line 1
    iget-object v0, p0, Lw9/d$c;->e:Lt9/e;

    .line 2
    .line 3
    invoke-interface {v0}, Lbd/a;->get()Ljava/lang/Object;

    .line 4
    .line 5
    .line 6
    move-result-object v0

    .line 7
    check-cast v0, Lu9/a;

    .line 8
    .line 9
    return-object v0
    .line 10
    .line 11
    .line 12
    .line 13
    .line 14
    .line 15
    .line 16
.end method

.method public final e(Lx9/a;Lx9/g;)V
    .locals 0

    .line 1
    invoke-static {p1}, Lx9/b;->a(Lx9/a;)Lx9/b;

    .line 2
    .line 3
    .line 4
    move-result-object p1

    .line 5
    invoke-static {p1}, Lt9/b;->a(Lt9/e;)Lt9/e;

    .line 6
    .line 7
    .line 8
    move-result-object p1

    .line 9
    iput-object p1, p0, Lw9/d$c;->c:Lt9/e;

    .line 10
    .line 11
    invoke-static {}, Lu9/h;->a()Lu9/h;

    .line 12
    .line 13
    .line 14
    move-result-object p1

    .line 15
    invoke-static {p1}, Lt9/b;->a(Lt9/e;)Lt9/e;

    .line 16
    .line 17
    .line 18
    move-result-object p1

    .line 19
    iput-object p1, p0, Lw9/d$c;->d:Lt9/e;

    .line 20
    .line 21
    iget-object p1, p0, Lw9/d$c;->c:Lt9/e;

    .line 22
    .line 23
    invoke-static {p1}, Lu9/b;->a(Lbd/a;)Lu9/b;

    .line 24
    .line 25
    .line 26
    move-result-object p1

    .line 27
    invoke-static {p1}, Lt9/b;->a(Lt9/e;)Lt9/e;

    .line 28
    .line 29
    .line 30
    move-result-object p1

    .line 31
    iput-object p1, p0, Lw9/d$c;->e:Lt9/e;

    .line 32
    .line 33
    iget-object p1, p0, Lw9/d$c;->c:Lt9/e;

    .line 34
    .line 35
    invoke-static {p2, p1}, Lx9/l;->a(Lx9/g;Lbd/a;)Lx9/l;

    .line 36
    .line 37
    .line 38
    move-result-object p1

    .line 39
    iput-object p1, p0, Lw9/d$c;->f:Lt9/e;

    .line 40
    .line 41
    invoke-static {p2, p1}, Lx9/p;->a(Lx9/g;Lbd/a;)Lx9/p;

    .line 42
    .line 43
    .line 44
    move-result-object p1

    .line 45
    iput-object p1, p0, Lw9/d$c;->g:Lt9/e;

    .line 46
    .line 47
    iget-object p1, p0, Lw9/d$c;->f:Lt9/e;

    .line 48
    .line 49
    invoke-static {p2, p1}, Lx9/m;->a(Lx9/g;Lbd/a;)Lx9/m;

    .line 50
    .line 51
    .line 52
    move-result-object p1

    .line 53
    iput-object p1, p0, Lw9/d$c;->h:Lt9/e;

    .line 54
    .line 55
    iget-object p1, p0, Lw9/d$c;->f:Lt9/e;

    .line 56
    .line 57
    invoke-static {p2, p1}, Lx9/n;->a(Lx9/g;Lbd/a;)Lx9/n;

    .line 58
    .line 59
    .line 60
    move-result-object p1

    .line 61
    iput-object p1, p0, Lw9/d$c;->i:Lt9/e;

    .line 62
    .line 63
    iget-object p1, p0, Lw9/d$c;->f:Lt9/e;

    .line 64
    .line 65
    invoke-static {p2, p1}, Lx9/o;->a(Lx9/g;Lbd/a;)Lx9/o;

    .line 66
    .line 67
    .line 68
    move-result-object p1

    .line 69
    iput-object p1, p0, Lw9/d$c;->j:Lt9/e;

    .line 70
    .line 71
    iget-object p1, p0, Lw9/d$c;->f:Lt9/e;

    .line 72
    .line 73
    invoke-static {p2, p1}, Lx9/j;->a(Lx9/g;Lbd/a;)Lx9/j;

    .line 74
    .line 75
    .line 76
    move-result-object p1

    .line 77
    iput-object p1, p0, Lw9/d$c;->k:Lt9/e;

    .line 78
    .line 79
    iget-object p1, p0, Lw9/d$c;->f:Lt9/e;

    .line 80
    .line 81
    invoke-static {p2, p1}, Lx9/k;->a(Lx9/g;Lbd/a;)Lx9/k;

    .line 82
    .line 83
    .line 84
    move-result-object p1

    .line 85
    iput-object p1, p0, Lw9/d$c;->l:Lt9/e;

    .line 86
    .line 87
    iget-object p1, p0, Lw9/d$c;->f:Lt9/e;

    .line 88
    .line 89
    invoke-static {p2, p1}, Lx9/i;->a(Lx9/g;Lbd/a;)Lx9/i;

    .line 90
    .line 91
    .line 92
    move-result-object p1

    .line 93
    iput-object p1, p0, Lw9/d$c;->m:Lt9/e;

    .line 94
    .line 95
    iget-object p1, p0, Lw9/d$c;->f:Lt9/e;

    .line 96
    .line 97
    invoke-static {p2, p1}, Lx9/h;->a(Lx9/g;Lbd/a;)Lx9/h;

    .line 98
    .line 99
    .line 100
    move-result-object p1

    .line 101
    iput-object p1, p0, Lw9/d$c;->n:Lt9/e;

    .line 102
    .line 103
    return-void
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
.end method
