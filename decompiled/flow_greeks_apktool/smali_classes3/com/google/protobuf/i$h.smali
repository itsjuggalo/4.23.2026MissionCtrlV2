.class public final Lcom/google/protobuf/i$h;
.super Ljava/lang/Object;
.source "r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/google/protobuf/i;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x19
    name = "h"
.end annotation


# instance fields
.field public final a:Lcom/google/protobuf/l;

.field public final b:[B


# direct methods
.method public constructor <init>(I)V
    .locals 0

    .line 2
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 3
    new-array p1, p1, [B

    iput-object p1, p0, Lcom/google/protobuf/i$h;->b:[B

    .line 4
    invoke-static {p1}, Lcom/google/protobuf/l;->b0([B)Lcom/google/protobuf/l;

    move-result-object p1

    iput-object p1, p0, Lcom/google/protobuf/i$h;->a:Lcom/google/protobuf/l;

    return-void
.end method

.method public synthetic constructor <init>(ILcom/google/protobuf/i$a;)V
    .locals 0

    .line 1
    invoke-direct {p0, p1}, Lcom/google/protobuf/i$h;-><init>(I)V

    return-void
.end method


# virtual methods
.method public a()Lcom/google/protobuf/i;
    .locals 2

    .line 1
    iget-object v0, p0, Lcom/google/protobuf/i$h;->a:Lcom/google/protobuf/l;

    .line 2
    .line 3
    invoke-virtual {v0}, Lcom/google/protobuf/l;->d()V

    .line 4
    .line 5
    .line 6
    new-instance v0, Lcom/google/protobuf/i$j;

    .line 7
    .line 8
    iget-object v1, p0, Lcom/google/protobuf/i$h;->b:[B

    .line 9
    .line 10
    invoke-direct {v0, v1}, Lcom/google/protobuf/i$j;-><init>([B)V

    .line 11
    .line 12
    .line 13
    return-object v0
    .line 14
    .line 15
    .line 16
    .line 17
    .line 18
    .line 19
.end method

.method public b()Lcom/google/protobuf/l;
    .locals 1

    .line 1
    iget-object v0, p0, Lcom/google/protobuf/i$h;->a:Lcom/google/protobuf/l;

    .line 2
    .line 3
    return-object v0
    .line 4
    .line 5
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
    .line 17
    .line 18
    .line 19
.end method
