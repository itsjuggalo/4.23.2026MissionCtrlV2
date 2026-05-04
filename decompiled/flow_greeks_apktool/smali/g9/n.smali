.class public Lg9/n;
.super Ljava/lang/Object;
.source "r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7"


# instance fields
.field public final a:Ljava/util/HashMap;


# direct methods
.method public constructor <init>()V
    .locals 1

    .line 1
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 2
    .line 3
    .line 4
    new-instance v0, Ljava/util/HashMap;

    .line 5
    .line 6
    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    .line 7
    .line 8
    .line 9
    iput-object v0, p0, Lg9/n;->a:Ljava/util/HashMap;

    .line 10
    .line 11
    return-void
    .line 12
    .line 13
    .line 14
    .line 15
    .line 16
.end method


# virtual methods
.method public a(Lg9/m;)V
    .locals 7

    .line 1
    invoke-virtual {p1}, Lg9/m;->b()Lj9/h;

    .line 2
    .line 3
    .line 4
    move-result-object v0

    .line 5
    invoke-interface {v0}, Lj9/h;->getKey()Lj9/k;

    .line 6
    .line 7
    .line 8
    move-result-object v0

    .line 9
    iget-object v1, p0, Lg9/n;->a:Ljava/util/HashMap;

    .line 10
    .line 11
    invoke-virtual {v1, v0}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    .line 12
    .line 13
    .line 14
    move-result-object v1

    .line 15
    check-cast v1, Lg9/m;

    .line 16
    .line 17
    if-nez v1, :cond_0

    .line 18
    .line 19
    iget-object v1, p0, Lg9/n;->a:Ljava/util/HashMap;

    .line 20
    .line 21
    invoke-virtual {v1, v0, p1}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 22
    .line 23
    .line 24
    return-void

    .line 25
    :cond_0
    invoke-virtual {v1}, Lg9/m;->c()Lg9/m$a;

    .line 26
    .line 27
    .line 28
    move-result-object v2

    .line 29
    invoke-virtual {p1}, Lg9/m;->c()Lg9/m$a;

    .line 30
    .line 31
    .line 32
    move-result-object v3

    .line 33
    sget-object v4, Lg9/m$a;->b:Lg9/m$a;

    .line 34
    .line 35
    if-eq v3, v4, :cond_1

    .line 36
    .line 37
    sget-object v5, Lg9/m$a;->d:Lg9/m$a;

    .line 38
    .line 39
    if-ne v2, v5, :cond_1

    .line 40
    .line 41
    iget-object v1, p0, Lg9/n;->a:Ljava/util/HashMap;

    .line 42
    .line 43
    invoke-virtual {v1, v0, p1}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 44
    .line 45
    .line 46
    return-void

    .line 47
    :cond_1
    sget-object v5, Lg9/m$a;->d:Lg9/m$a;

    .line 48
    .line 49
    if-ne v3, v5, :cond_2

    .line 50
    .line 51
    sget-object v5, Lg9/m$a;->a:Lg9/m$a;

    .line 52
    .line 53
    if-eq v2, v5, :cond_2

    .line 54
    .line 55
    invoke-virtual {p1}, Lg9/m;->b()Lj9/h;

    .line 56
    .line 57
    .line 58
    move-result-object p1

    .line 59
    invoke-static {v2, p1}, Lg9/m;->a(Lg9/m$a;Lj9/h;)Lg9/m;

    .line 60
    .line 61
    .line 62
    move-result-object p1

    .line 63
    iget-object v1, p0, Lg9/n;->a:Ljava/util/HashMap;

    .line 64
    .line 65
    invoke-virtual {v1, v0, p1}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 66
    .line 67
    .line 68
    return-void

    .line 69
    :cond_2
    sget-object v5, Lg9/m$a;->c:Lg9/m$a;

    .line 70
    .line 71
    if-ne v3, v5, :cond_3

    .line 72
    .line 73
    if-ne v2, v5, :cond_3

    .line 74
    .line 75
    invoke-virtual {p1}, Lg9/m;->b()Lj9/h;

    .line 76
    .line 77
    .line 78
    move-result-object p1

    .line 79
    invoke-static {v5, p1}, Lg9/m;->a(Lg9/m$a;Lj9/h;)Lg9/m;

    .line 80
    .line 81
    .line 82
    move-result-object p1

    .line 83
    iget-object v1, p0, Lg9/n;->a:Ljava/util/HashMap;

    .line 84
    .line 85
    invoke-virtual {v1, v0, p1}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 86
    .line 87
    .line 88
    return-void

    .line 89
    :cond_3
    if-ne v3, v5, :cond_4

    .line 90
    .line 91
    if-ne v2, v4, :cond_4

    .line 92
    .line 93
    invoke-virtual {p1}, Lg9/m;->b()Lj9/h;

    .line 94
    .line 95
    .line 96
    move-result-object p1

    .line 97
    invoke-static {v4, p1}, Lg9/m;->a(Lg9/m$a;Lj9/h;)Lg9/m;

    .line 98
    .line 99
    .line 100
    move-result-object p1

    .line 101
    iget-object v1, p0, Lg9/n;->a:Ljava/util/HashMap;

    .line 102
    .line 103
    invoke-virtual {v1, v0, p1}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 104
    .line 105
    .line 106
    return-void

    .line 107
    :cond_4
    sget-object v6, Lg9/m$a;->a:Lg9/m$a;

    .line 108
    .line 109
    if-ne v3, v6, :cond_5

    .line 110
    .line 111
    if-ne v2, v4, :cond_5

    .line 112
    .line 113
    iget-object p1, p0, Lg9/n;->a:Ljava/util/HashMap;

    .line 114
    .line 115
    invoke-virtual {p1, v0}, Ljava/util/HashMap;->remove(Ljava/lang/Object;)Ljava/lang/Object;

    .line 116
    .line 117
    .line 118
    return-void

    .line 119
    :cond_5
    if-ne v3, v6, :cond_6

    .line 120
    .line 121
    if-ne v2, v5, :cond_6

    .line 122
    .line 123
    invoke-virtual {v1}, Lg9/m;->b()Lj9/h;

    .line 124
    .line 125
    .line 126
    move-result-object p1

    .line 127
    invoke-static {v6, p1}, Lg9/m;->a(Lg9/m$a;Lj9/h;)Lg9/m;

    .line 128
    .line 129
    .line 130
    move-result-object p1

    .line 131
    iget-object v1, p0, Lg9/n;->a:Ljava/util/HashMap;

    .line 132
    .line 133
    invoke-virtual {v1, v0, p1}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 134
    .line 135
    .line 136
    return-void

    .line 137
    :cond_6
    if-ne v3, v4, :cond_7

    .line 138
    .line 139
    if-ne v2, v6, :cond_7

    .line 140
    .line 141
    invoke-virtual {p1}, Lg9/m;->b()Lj9/h;

    .line 142
    .line 143
    .line 144
    move-result-object p1

    .line 145
    invoke-static {v5, p1}, Lg9/m;->a(Lg9/m$a;Lj9/h;)Lg9/m;

    .line 146
    .line 147
    .line 148
    move-result-object p1

    .line 149
    iget-object v1, p0, Lg9/n;->a:Ljava/util/HashMap;

    .line 150
    .line 151
    invoke-virtual {v1, v0, p1}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 152
    .line 153
    .line 154
    return-void

    .line 155
    :cond_7
    const-string p1, "Unsupported combination of changes %s after %s"

    .line 156
    .line 157
    filled-new-array {v3, v2}, [Ljava/lang/Object;

    .line 158
    .line 159
    .line 160
    move-result-object v0

    .line 161
    invoke-static {p1, v0}, Ln9/b;->a(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/AssertionError;

    .line 162
    .line 163
    .line 164
    move-result-object p1

    .line 165
    throw p1
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

.method public b()Ljava/util/List;
    .locals 2

    .line 1
    new-instance v0, Ljava/util/ArrayList;

    .line 2
    .line 3
    iget-object v1, p0, Lg9/n;->a:Ljava/util/HashMap;

    .line 4
    .line 5
    invoke-virtual {v1}, Ljava/util/HashMap;->values()Ljava/util/Collection;

    .line 6
    .line 7
    .line 8
    move-result-object v1

    .line 9
    invoke-direct {v0, v1}, Ljava/util/ArrayList;-><init>(Ljava/util/Collection;)V

    .line 10
    .line 11
    .line 12
    return-object v0
    .line 13
    .line 14
    .line 15
    .line 16
.end method
