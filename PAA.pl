#!/usr/bin/perl

#Projeto do codigo de Huffman
#PAA - 2017
#Maycon Q

open(IN, "<in.txt") or die "Nao deu pra abrir o arquivo $!";

while(<IN>){
   @K = split(//, "$_");
   foreach (@K){
     $data{$_} = $data{$_}+1;
   }
}
close(IN);
$T = keys %data;
while ($T > 1){
  @D1 = keys %data;
  $M1 = $data{$D1[0]};
  $C1 = $D1[0];
  foreach (keys %data){
    if ($data{$_} < $M1){ #Compara Minimos para todo o vetor
      $M1 = $data{$_};
      $C1 = $_;
    }
  }
  delete $data{$C1};
  @D1 = keys %data;
  $M2 = $data{$D1[0]};
  $C2 = $D1[0];
  foreach (keys %data){
    if ($data{$_} < $M2){ #Compara Minimos para todo o vetor
      $M2 = $data{$_};
      $C2 = $_;
    }
  }
  delete $data{$C2};
  $data{"($C1,$C2)"}=$M1+$M2;
  $T--;
}
@D1 = keys %data;
@K = split(//, "$D1[0]"); #Para ver a arvore, imprima K
#print ("-@K-\n");
delete $data{$D1[0]};
@B = undef;
$i = 0;
foreach (@K){
  if ($_ eq "("){
    $B[$i] = 0;
    $i++;
  }
  elsif ($_ eq ","){
    $B[$i-1] = 1;
  }
  elsif ($_ eq ")"){
    $i--;
    $B[$i-1] = 1;
    splice @B, $i, @B;
  }
  else {
    $data{$_} = join('', @B);
  }
}
$i = 0;
open(IN, "<in.txt") or die "Nao deu pra abrir o arquivo $!";
open(OT, ">out.txt") or die "Nao deu pra abrir o arquivo $!";
$T1 = 0;
while(<IN>){
   @K = split(//, "$_");
   foreach (@K){
     print OT ("$data{$_}");
     $T1++;
   }
}
$T1 = $T1 * 8;
close (IN);
close (OT);
open(OT, "<out.txt") or die "Nao deu pra abrir o arquivo $!";
$T2 = 0;
while(<OT>){
   @K = split(//, "$_");
   $T2 = $T2 + @K;
}
close (OT);
$Diff = $T1 - $T2;
print ("Ganho = $Diff. T1 = $T1. T2 = $T2");
