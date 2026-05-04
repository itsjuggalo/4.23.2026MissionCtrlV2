.class public final Lua/t0$e$a;
.super Lid/m;
.source "r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7"

# interfaces
.implements Lpd/o;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lua/t0$e;->invokeSuspend(Ljava/lang/Object;)Ljava/lang/Object;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x19
    name = null
.end annotation


# instance fields
.field public a:I

.field public synthetic b:Ljava/lang/Object;

.field public final synthetic c:Lua/t0;


# direct methods
.method public constructor <init>(Lua/t0;Lgd/e;)V
    .locals 0

    .line 1
    iput-object p1, p0, Lua/t0$e$a;->c:Lua/t0;

    .line 2
    .line 3
    const/4 p1, 0x2

    .line 4
    invoke-direct {p0, p1, p2}, Lid/m;-><init>(ILgd/e;)V

    .line 5
    .line 6
    .line 7
    return-void
    .line 8
    .line 9
    .line 10
    .line 11
    .line 12
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
.end method


# virtual methods
.method public final a(Lua/e0;Lgd/e;)Ljava/lang/Object;
    .locals 0

    .line 1
    invoke-virtual {p0, p1, p2}, Lua/t0$e$a;->create(Ljava/lang/Object;Lgd/e;)Lgd/e;

    .line 2
    .line 3
    .line 4
    move-result-object p1

    .line 5
    check-cast p1, Lua/t0$e$a;

    .line 6
    .line 7
    sget-object p2, Lcd/h0;->a:Lcd/h0;

    .line 8
    .line 9
    invoke-virtual {p1, p2}, Lua/t0$e$a;->invokeSuspend(Ljava/lang/Object;)Ljava/lang/Object;

    .line 10
    .line 11
    .line 12
    move-result-object p1

    .line 13
    return-object p1
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
.end method

.method public final create(Ljava/lang/Object;Lgd/e;)Lgd/e;
    .locals 2

    .line 1
    new-instance v0, Lua/t0$e$a;

    .line 2
    .line 3
    iget-object v1, p0, Lua/t0$e$a;->c:Lua/t0;

    .line 4
    .line 5
    invoke-direct {v0, v1, p2}, Lua/t0$e$a;-><init>(Lua/t0;Lgd/e;)V

    .line 6
    .line 7
    .line 8
    iput-object p1, v0, Lua/t0$e$a;->b:Ljava/lang/Object;

    .line 9
    .line 10
    return-object v0
    .line 11
    .line 12
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
.end method

.method public bridge synthetic invoke(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    .locals 0

    .line 1
    check-cast p1, Lua/e0;

    .line 2
    .line 3
    check-cast p2, Lgd/e;

    .line 4
    .line 5
    invoke-virtual {p0, p1, p2}, Lua/t0$e$a;->a(Lua/e0;Lgd/e;)Ljava/lang/Object;

    .line 6
    .line 7
    .line 8
    move-result-object p1

    .line 9
    return-object p1
    .line 10
    .line 11
    .line 12
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
.end method

.method public final invokeSuspend(Ljava/lang/Object;)Ljava/lang/Object;
    .locals 6

    .line 1
    invoke-static {}, Lhd/c;->f()Ljava/lang/Object;

    .line 2
    .line 3
    .line 4
    iget v0, p0, Lua/t0$e$a;->a:I

    .line 5
    .line 6
    if-nez v0, :cond_6

    .line 7
    .line 8
    invoke-static {p1}, Lcd/s;->b(Ljava/lang/Object;)V

    .line 9
    .line 10
    .line 11
    iget-object p1, p0, Lua/t0$e$a;->b:Ljava/lang/Object;

    .line 12
    .line 13
    move-object v0, p1

    .line 14
    check-cast v0, Lua/e0;

    .line 15
    .line 16
    iget-object p1, p0, Lua/t0$e$a;->c:Lua/t0;

    .line 17
    .line 18
    invoke-static {p1, v0}, Lua/t0;->k(Lua/t0;Lua/e0;)Z

    .line 19
    .line 20
    .line 21
    move-result p1

    .line 22
    iget-object v1, p0, Lua/t0$e$a;->c:Lua/t0;

    .line 23
    .line 24
    invoke-static {v1, v0}, Lua/t0;->i(Lua/t0;Lua/e0;)Z

    .line 25
    .line 26
    .line 27
    move-result v1

    .line 28
    iget-object v2, p0, Lua/t0$e$a;->c:Lua/t0;

    .line 29
    .line 30
    invoke-static {v2, v0}, Lua/t0;->j(Lua/t0;Lua/e0;)Z

    .line 31
    .line 32
    .line 33
    move-result v2

    .line 34
    if-eqz v1, :cond_0

    .line 35
    .line 36
    iget-object v3, p0, Lua/t0$e$a;->c:Lua/t0;

    .line 37
    .line 38
    invoke-static {v3}, Lua/t0;->d(Lua/t0;)Lua/w;

    .line 39
    .line 40
    .line 41
    move-result-object v3

    .line 42
    invoke-interface {v3}, Lua/w;->e()Ljava/util/Map;

    .line 43
    .line 44
    .line 45
    move-result-object v3

    .line 46
    goto :goto_0

    .line 47
    :cond_0
    if-eqz v2, :cond_1

    .line 48
    .line 49
    iget-object v3, p0, Lua/t0$e$a;->c:Lua/t0;

    .line 50
    .line 51
    invoke-static {v3}, Lua/t0;->d(Lua/t0;)Lua/w;

    .line 52
    .line 53
    .line 54
    move-result-object v3

    .line 55
    invoke-virtual {v0}, Lua/e0;->e()Ljava/util/Map;

    .line 56
    .line 57
    .line 58
    move-result-object v4

    .line 59
    invoke-interface {v3, v4}, Lua/w;->f(Ljava/util/Map;)Ljava/util/Map;

    .line 60
    .line 61
    .line 62
    move-result-object v3

    .line 63
    goto :goto_0

    .line 64
    :cond_1
    invoke-virtual {v0}, Lua/e0;->e()Ljava/util/Map;

    .line 65
    .line 66
    .line 67
    move-result-object v3

    .line 68
    :goto_0
    const/4 v4, 0x0

    .line 69
    if-eqz v1, :cond_2

    .line 70
    .line 71
    move-object v5, v4

    .line 72
    goto :goto_1

    .line 73
    :cond_2
    invoke-virtual {v0}, Lua/e0;->f()Lua/h0;

    .line 74
    .line 75
    .line 76
    move-result-object v5

    .line 77
    :goto_1
    if-nez p1, :cond_5

    .line 78
    .line 79
    if-eqz v1, :cond_3

    .line 80
    .line 81
    goto :goto_2

    .line 82
    :cond_3
    if-eqz v2, :cond_4

    .line 83
    .line 84
    iget-object p1, p0, Lua/t0$e$a;->c:Lua/t0;

    .line 85
    .line 86
    invoke-static {p1}, Lua/t0;->d(Lua/t0;)Lua/w;

    .line 87
    .line 88
    .line 89
    move-result-object p1

    .line 90
    invoke-interface {p1, v3}, Lua/w;->f(Ljava/util/Map;)Ljava/util/Map;

    .line 91
    .line 92
    .line 93
    move-result-object v3

    .line 94
    const/4 v4, 0x3

    .line 95
    const/4 v5, 0x0

    .line 96
    const/4 v1, 0x0

    .line 97
    const/4 v2, 0x0

    .line 98
    invoke-static/range {v0 .. v5}, Lua/e0;->c(Lua/e0;Lua/h0;Lua/v0;Ljava/util/Map;ILjava/lang/Object;)Lua/e0;

    .line 99
    .line 100
    .line 101
    move-result-object p1

    .line 102
    return-object p1

    .line 103
    :cond_4
    return-object v0

    .line 104
    :cond_5
    :goto_2
    iget-object p1, p0, Lua/t0$e$a;->c:Lua/t0;

    .line 105
    .line 106
    invoke-static {p1}, Lua/t0;->g(Lua/t0;)Lua/n0;

    .line 107
    .line 108
    .line 109
    move-result-object p1

    .line 110
    invoke-virtual {p1, v5}, Lua/n0;->a(Lua/h0;)Lua/h0;

    .line 111
    .line 112
    .line 113
    move-result-object p1

    .line 114
    iget-object v1, p0, Lua/t0$e$a;->c:Lua/t0;

    .line 115
    .line 116
    invoke-static {v1}, Lua/t0;->f(Lua/t0;)Lua/k0;

    .line 117
    .line 118
    .line 119
    move-result-object v1

    .line 120
    invoke-interface {v1, p1}, Lua/k0;->a(Lua/h0;)V

    .line 121
    .line 122
    .line 123
    iget-object v1, p0, Lua/t0$e$a;->c:Lua/t0;

    .line 124
    .line 125
    invoke-static {v1}, Lua/t0;->d(Lua/t0;)Lua/w;

    .line 126
    .line 127
    .line 128
    move-result-object v1

    .line 129
    invoke-interface {v1}, Lua/w;->a()V

    .line 130
    .line 131
    .line 132
    invoke-virtual {v0, p1, v4, v3}, Lua/e0;->b(Lua/h0;Lua/v0;Ljava/util/Map;)Lua/e0;

    .line 133
    .line 134
    .line 135
    move-result-object p1

    .line 136
    return-object p1

    .line 137
    :cond_6
    new-instance p1, Ljava/lang/IllegalStateException;

    .line 138
    .line 139
    const-string v0, "call to \'resume\' before \'invoke\' with coroutine"

    .line 140
    .line 141
    invoke-direct {p1, v0}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    .line 142
    .line 143
    .line 144
    throw p1
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
    .line 197
.end method
