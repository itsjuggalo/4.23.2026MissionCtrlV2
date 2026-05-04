.class public Lj8/y$a;
.super Ljava/lang/Object;
.source "r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7"

# interfaces
.implements Ljava/util/concurrent/Callable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lj8/y;->E(Lj8/l;Ljava/util/Map;Lj8/z;)Ljava/util/List;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x1
    name = null
.end annotation


# instance fields
.field public final synthetic a:Lj8/z;

.field public final synthetic b:Lj8/l;

.field public final synthetic c:Ljava/util/Map;

.field public final synthetic d:Lj8/y;


# direct methods
.method public constructor <init>(Lj8/y;Lj8/z;Lj8/l;Ljava/util/Map;)V
    .locals 0

    .line 1
    iput-object p1, p0, Lj8/y$a;->d:Lj8/y;

    .line 2
    .line 3
    iput-object p2, p0, Lj8/y$a;->a:Lj8/z;

    .line 4
    .line 5
    iput-object p3, p0, Lj8/y$a;->b:Lj8/l;

    .line 6
    .line 7
    iput-object p4, p0, Lj8/y$a;->c:Ljava/util/Map;

    .line 8
    .line 9
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

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
.method public a()Ljava/util/List;
    .locals 5

    .line 1
    iget-object v0, p0, Lj8/y$a;->d:Lj8/y;

    .line 2
    .line 3
    iget-object v1, p0, Lj8/y$a;->a:Lj8/z;

    .line 4
    .line 5
    invoke-static {v0, v1}, Lj8/y;->l(Lj8/y;Lj8/z;)Lo8/i;

    .line 6
    .line 7
    .line 8
    move-result-object v0

    .line 9
    if-eqz v0, :cond_0

    .line 10
    .line 11
    invoke-virtual {v0}, Lo8/i;->e()Lj8/l;

    .line 12
    .line 13
    .line 14
    move-result-object v1

    .line 15
    iget-object v2, p0, Lj8/y$a;->b:Lj8/l;

    .line 16
    .line 17
    invoke-static {v1, v2}, Lj8/l;->R(Lj8/l;Lj8/l;)Lj8/l;

    .line 18
    .line 19
    .line 20
    move-result-object v1

    .line 21
    iget-object v2, p0, Lj8/y$a;->c:Ljava/util/Map;

    .line 22
    .line 23
    invoke-static {v2}, Lj8/b;->r(Ljava/util/Map;)Lj8/b;

    .line 24
    .line 25
    .line 26
    move-result-object v2

    .line 27
    iget-object v3, p0, Lj8/y$a;->d:Lj8/y;

    .line 28
    .line 29
    invoke-static {v3}, Lj8/y;->c(Lj8/y;)Ll8/e;

    .line 30
    .line 31
    .line 32
    move-result-object v3

    .line 33
    iget-object v4, p0, Lj8/y$a;->b:Lj8/l;

    .line 34
    .line 35
    invoke-interface {v3, v4, v2}, Ll8/e;->g(Lj8/l;Lj8/b;)V

    .line 36
    .line 37
    .line 38
    new-instance v3, Lk8/c;

    .line 39
    .line 40
    invoke-virtual {v0}, Lo8/i;->d()Lo8/h;

    .line 41
    .line 42
    .line 43
    move-result-object v4

    .line 44
    invoke-static {v4}, Lk8/e;->a(Lo8/h;)Lk8/e;

    .line 45
    .line 46
    .line 47
    move-result-object v4

    .line 48
    invoke-direct {v3, v4, v1, v2}, Lk8/c;-><init>(Lk8/e;Lj8/l;Lj8/b;)V

    .line 49
    .line 50
    .line 51
    iget-object v1, p0, Lj8/y$a;->d:Lj8/y;

    .line 52
    .line 53
    invoke-static {v1, v0, v3}, Lj8/y;->m(Lj8/y;Lo8/i;Lk8/d;)Ljava/util/List;

    .line 54
    .line 55
    .line 56
    move-result-object v0

    .line 57
    return-object v0

    .line 58
    :cond_0
    sget-object v0, Ljava/util/Collections;->EMPTY_LIST:Ljava/util/List;

    .line 59
    .line 60
    return-object v0
    .line 61
.end method

.method public bridge synthetic call()Ljava/lang/Object;
    .locals 1

    .line 1
    invoke-virtual {p0}, Lj8/y$a;->a()Ljava/util/List;

    .line 2
    .line 3
    .line 4
    move-result-object v0

    .line 5
    return-object v0
    .line 6
    .line 7
    .line 8
    .line 9
    .line 10
    .line 11
    .line 12
    .line 13
    .line 14
    .line 15
    .line 16
.end method
