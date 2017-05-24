#!/usr/bin/perl

#Projeto do codigo de Huffman
#PAA - 2017
#Maycon Q

#Verifica se estao em ordem
sub Doublecheck{
  $ORD = 0;
  for (my $i = 0; $i < $TAM-1; $i++) {
    $ORD = 1 if $_[$i] > $_[$i+1];
  }
  return $ORD;
}

#Inicia TAM : Tamanho do vetor
#MED : Media dos elementos do vetor
#MIN : Valor minimo encontrado no vetor
#MAX : Valor maximo encontrado no vetor
#QFX : Quantidade de frequencias
#RFX : Range das frequencias
sub Iniciais{
  $TAM = @_; #Tamanho do vetor
  $MAX = $_[0]; #Inicializa Maximo
  $MIN = $_[$TAM-1]; #Inicializa Minimo
  foreach (@_){
    $MIN = $_ if $_ < $MIN; #Compara Minimos para todo o vetor
    $MAX = $_ if $_ > $MAX; #Compara Maximos para todo o vetor
  }
  my $V = $MAX - $MIN; #Range
  $QFX = int(sqrt($TAM)); #Quantidade de Frequencias
  $RFX = $V/$QFX; #Range das frequencias
  #print "MAX = $MAX; MIN = $MIN; MAX-MIN = $V; RFX = $RFX; QFX = $QFX\n";
  for (my $i = 0; $i < $QFX; $i++) {
    #Separa um vetor para armazenar quantos elementos tem por frequencia
    #E o inicializa zerado
    $DIV[$i] = 0;
  }
}

#Determina quantos cabras tem para cada frequencia
sub DivideFreq{
  my $V = $MIN; #Valor que varia carregando o valor minimo mais o range
  my $C = 0; #Curinga
  foreach (@_){
    $C = ($_ - ($_ % $RFX)) / $RFX; #Decide em qual posicao o elemento ficara
    $DIV[$C]++;
  }
  $C = 0;
  foreach (@DIV){
    #Para cada elemento, soma com os anteriores
    #para saber onde comeca a sua parte
    $C += $_;
    $_ = $C;
  }
  for (my $i = $QFX; $i > 0; $i--) {
    #Recebe o valor do anterior
    $DIV[$i] = $DIV[$i-1];
  }
  $DIV[0] = 0;
}

#Coloca os elementos de L1 em L2
#De acordo com a distribuicao de frequencias
#Onde os elementos vao parar em casas especificas dependendo de seu valor
sub Carrega12F{
  my $C = 0; #Curinga
  my $P = 0; #Posicao para insercao
  foreach (@_){
    $C = ($_ - ($_ % $RFX)) / $RFX; #Calcula posicao
    $P = $DIV[$C]++; #Incrementa naquela frequencia
    #$P = ($C == 0) ? 0 : ($DIV[$C-1]++);
    $L2[$P] = $_; #Poe no segundo vetor
  }
}

sub InsertionSort{
  my (@list) = @_;
  foreach my $i (1 .. $#list) {
      my $j = $i;
      my $k = $list[$i];
      while ( $j > 0 && $k < $list[$j - 1]) {
          $list[$j] = $list[$j - 1];
          $j--;
      }
      $list[$j] = $k;
  }
  return @list;
}

sub Imprimeemsaida{
  open(OUT, ">out.txt") or die "Nao deu pra abrir o arquivo $!";
  print OUT "$TAM $MIN $MAX $QFX $RFX\n";
  foreach(@DIV){
    print OUT "$_ ";
  }
  print OUT "\n";
  foreach(@_){
    print OUT "$_\n";
  }
}

open(IN, "<In.txt") or die "Nao deu pra abrir o arquivo $!";
open(OT, ">Log.txt") or die "Nao deu pra abrir o arquivo $!";
chomp(@L1 = <IN>);
close(IN);
$TAM = @L1;
my $start = Time::HiRes::gettimeofday();
Iniciais(@L1);
my $end = Time::HiRes::gettimeofday();
$d1 = $end - $start;
#Nada acima daqui!
my $start = Time::HiRes::gettimeofday();
DivideFreq(@L1);
my $end = Time::HiRes::gettimeofday();
$d2 = $end - $start;
my $start = Time::HiRes::gettimeofday();
Carrega12F(@L1);
my $end = Time::HiRes::gettimeofday();
$d3 = $end - $start;
#Carrega12M(@L1);
#Rquad(@L2);
Imprimeemsaida(@L2);
my $start = Time::HiRes::gettimeofday();
@L2 = InsertionSort(@L2);
my $end = Time::HiRes::gettimeofday();
$d4 = $end - $start;
print OT "$TAM $d1 $d2 $d3 $d4\n";
