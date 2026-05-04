.class public final Ll1/a0$a$a;
.super Lid/m;
.source "r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7"

# interfaces
.implements Lpd/o;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Ll1/a0$a;->e(Ljava/io/File;)Lqg/d;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x19
    name = null
.end annotation


# instance fields
.field public a:Ljava/lang/Object;

.field public b:I

.field public synthetic c:Ljava/lang/Object;

.field public final synthetic d:Ljava/io/File;


# direct methods
.method public constructor <init>(Ljava/io/File;Lgd/e;)V
    .locals 0

    .line 1
    iput-object p1, p0, Ll1/a0$a$a;->d:Ljava/io/File;

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
.method public final a(Lpg/v;Lgd/e;)Ljava/lang/Object;
    .locals 0

    .line 1
    invoke-virtual {p0, p1, p2}, Ll1/a0$a$a;->create(Ljava/lang/Object;Lgd/e;)Lgd/e;

    .line 2
    .line 3
    .line 4
    move-result-object p1

    .line 5
    check-cast p1, Ll1/a0$a$a;

    .line 6
    .line 7
    sget-object p2, Lcd/h0;->a:Lcd/h0;

    .line 8
    .line 9
    invoke-virtual {p1, p2}, Ll1/a0$a$a;->invokeSuspend(Ljava/lang/Object;)Ljava/lang/Object;

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
    new-instance v0, Ll1/a0$a$a;

    .line 2
    .line 3
    iget-object v1, p0, Ll1/a0$a$a;->d:Ljava/io/File;

    .line 4
    .line 5
    invoke-direct {v0, v1, p2}, Ll1/a0$a$a;-><init>(Ljava/io/File;Lgd/e;)V

    .line 6
    .line 7
    .line 8
    iput-object p1, v0, Ll1/a0$a$a;->c:Ljava/lang/Object;

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
    check-cast p1, Lpg/v;

    .line 2
    .line 3
    check-cast p2, Lgd/e;

    .line 4
    .line 5
    invoke-virtual {p0, p1, p2}, Ll1/a0$a$a;->a(Lpg/v;Lgd/e;)Ljava/lang/Object;

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
    move-result-object v0

    .line 5
    iget v1, p0, Ll1/a0$a$a;->b:I

    .line 6
    .line 7
    const/4 v2, 0x2

    .line 8
    const/4 v3, 0x1

    .line 9
    if-eqz v1, :cond_2

    .line 10
    .line 11
    if-eq v1, v3, :cond_1

    .line 12
    .line 13
    if-ne v1, v2, :cond_0

    .line 14
    .line 15
    invoke-static {p1}, Lcd/s;->b(Ljava/lang/Object;)V

    .line 16
    .line 17
    .line 18
    goto :goto_2

    .line 19
    :cond_0
    new-instance p1, Ljava/lang/IllegalStateException;

    .line 20
    .line 21
    const-string v0, "call to \'resume\' before \'invoke\' with coroutine"

    .line 22
    .line 23
    invoke-direct {p1, v0}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    .line 24
    .line 25
    .line 26
    throw p1

    .line 27
    :cond_1
    iget-object v1, p0, Ll1/a0$a$a;->a:Ljava/lang/Object;

    .line 28
    .line 29
    check-cast v1, Lng/e1;

    .line 30
    .line 31
    iget-object v3, p0, Ll1/a0$a$a;->c:Ljava/lang/Object;

    .line 32
    .line 33
    check-cast v3, Lpg/v;

    .line 34
    .line 35
    invoke-static {p1}, Lcd/s;->b(Ljava/lang/Object;)V

    .line 36
    .line 37
    .line 38
    goto :goto_0

    .line 39
    :cond_2
    invoke-static {p1}, Lcd/s;->b(Ljava/lang/Object;)V

    .line 40
    .line 41
    .line 42
    iget-object p1, p0, Ll1/a0$a$a;->c:Ljava/lang/Object;

    .line 43
    .line 44
    check-cast p1, Lpg/v;

    .line 45
    .line 46
    new-instance v1, Ll1/a0$a$a$b;

    .line 47
    .line 48
    iget-object v4, p0, Ll1/a0$a$a;->d:Ljava/io/File;

    .line 49
    .line 50
    invoke-direct {v1, v4, p1}, Ll1/a0$a$a$b;-><init>(Ljava/io/File;Lpg/v;)V

    .line 51
    .line 52
    .line 53
    sget-object v4, Ll1/a0;->c:Ll1/a0$a;

    .line 54
    .line 55
    iget-object v5, p0, Ll1/a0$a$a;->d:Ljava/io/File;

    .line 56
    .line 57
    invoke-virtual {v5}, Ljava/io/File;->getParentFile()Ljava/io/File;

    .line 58
    .line 59
    .line 60
    move-result-object v5

    .line 61
    invoke-static {v5}, Lkotlin/jvm/internal/t;->c(Ljava/lang/Object;)V

    .line 62
    .line 63
    .line 64
    invoke-static {v4, v5, v1}, Ll1/a0$a;->b(Ll1/a0$a;Ljava/io/File;Lpd/k;)Lng/e1;

    .line 65
    .line 66
    .line 67
    move-result-object v1

    .line 68
    sget-object v4, Lcd/h0;->a:Lcd/h0;

    .line 69
    .line 70
    iput-object p1, p0, Ll1/a0$a$a;->c:Ljava/lang/Object;

    .line 71
    .line 72
    iput-object v1, p0, Ll1/a0$a$a;->a:Ljava/lang/Object;

    .line 73
    .line 74
    iput v3, p0, Ll1/a0$a$a;->b:I

    .line 75
    .line 76
    invoke-interface {p1, v4, p0}, Lpg/x;->i(Ljava/lang/Object;Lgd/e;)Ljava/lang/Object;

    .line 77
    .line 78
    .line 79
    move-result-object v3

    .line 80
    if-ne v3, v0, :cond_3

    .line 81
    .line 82
    goto :goto_1

    .line 83
    :cond_3
    move-object v3, p1

    .line 84
    :goto_0
    new-instance p1, Ll1/a0$a$a$a;

    .line 85
    .line 86
    invoke-direct {p1, v1}, Ll1/a0$a$a$a;-><init>(Lng/e1;)V

    .line 87
    .line 88
    .line 89
    const/4 v1, 0x0

    .line 90
    iput-object v1, p0, Ll1/a0$a$a;->c:Ljava/lang/Object;

    .line 91
    .line 92
    iput-object v1, p0, Ll1/a0$a$a;->a:Ljava/lang/Object;

    .line 93
    .line 94
    iput v2, p0, Ll1/a0$a$a;->b:I

    .line 95
    .line 96
    invoke-static {v3, p1, p0}, Lpg/t;->a(Lpg/v;Lkotlin/jvm/functions/Function0;Lgd/e;)Ljava/lang/Object;

    .line 97
    .line 98
    .line 99
    move-result-object p1

    .line 100
    if-ne p1, v0, :cond_4

    .line 101
    .line 102
    :goto_1
    return-object v0

    .line 103
    :cond_4
    :goto_2
    sget-object p1, Lcd/h0;->a:Lcd/h0;

    .line 104
    .line 105
    return-object p1
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
    .line 197
.end method
