package modulo;

final class Clasa_de_resturi {
            private long a,p;
            private final static long pmax=new Double(Math.sqrt(Long.MAX_VALUE)).longValue();
            private static boolean e_valid(long p1) {
            	if(p1<=Clasa_de_resturi.pmax&&p1>=1) {
            		return true;
            	}
            	else {
            		return false;
            	}
            }
            private static java.lang.ArithmeticException aruncare_exceptie(long p1){
            	if(p1<=0){
            		return new java.lang.ArithmeticException("Numarul modulus nu e natural nenul.");
            	}
            	else{
            		return new java.lang.ArithmeticException("Numarul modulus e strict mai mare decat "+pmax+'.');
            	}
            }
            Clasa_de_resturi(long a1,long p1) {
            	if(Clasa_de_resturi.e_valid(p1)) {
            	  p=p1;
            	  a=Clasa_de_resturi.result(a1, p);
            	}
            }
            public static long result(long a1,long p1) { // Afla congruentul lui a1 aflat in intervalul [0, p1-1]
            	if(Clasa_de_resturi.e_valid(p1)) {
            	  while(a1>=p1) {
            		   a1-=p1;
            		   }
            	  while(a1<0) {
            		   a1+=p1;
            		   }
            	  return a1;
            	}
            	else {
            		throw Clasa_de_resturi.aruncare_exceptie(p1);
            	}
            }
            public long geta() {
            	return a;
            	}
            public void seta(long a1) {
            	a=result(a1,p);
            	}
            public long getp() {
            	return p;
            	}
            public void setp(long p1) {
            	if(Clasa_de_resturi.e_valid(p1)) {
            	    p=p1;
            	    a=Clasa_de_resturi.result(a,p);}
            	else {
            	    throw new java.lang.ArithmeticException("Numarul introdus e <= 0.");
            	     }
                }
            public long complement() {// Afla numarul b astfel incat a+b = p. Complementul unui numar e egal cu opusul sau modulo p.
            	return Clasa_de_resturi.result(-a,p);
            	}
            public long opus() {// Afla congruentul lui -a aflat in intervalul [0,p-1].
            	return Clasa_de_resturi.result(-a,p);
            	}
            public static long complement(long a1,long p1) {// Afla numarul b astfel incat a + b = p. Complementul unui numar e egal cu opusul sau modulo p.
            	return Clasa_de_resturi.result(a1,p1);
            	}
            public static long opus(long a1, long p1) {// Afla congruentul lui -a aflat in intervalul [0,p-1].
            	return Clasa_de_resturi.result(-a1, p1);
            	}
            public static long inmultire(long a1,long b1,long p1) {// Calculeaza, in mod eficient, produsul a doua clase de resturi modulo p1.
            	if(Clasa_de_resturi.e_valid(p1)) {
            	  if((a1>p1/2&&b1>p1/2)||(a1+b1>(p1-a1)+(p1-b1))) {
            	    return Clasa_de_resturi.result(Clasa_de_resturi.opus(a1, p1)*Clasa_de_resturi.opus(b1, p1), p1);
            	    }
            	  else {
        			   return Clasa_de_resturi.result(a1*b1, p1);
            	       }
                  }
            	else {
            		throw Clasa_de_resturi.aruncare_exceptie(p1);
            	}
            }
            public long inmultire(long b) {// Calculeaza, in mod eficient, produsul a doua clase de resturi modulo p1.
            	if((a>p/2&&b>p/2)||(a+b>(p-a)+(p-b))) {
            		return Clasa_de_resturi.result(Clasa_de_resturi.opus(b, p)*opus(), p);
            	}
            	else {
            		return Clasa_de_resturi.result(a*b, p);
            	}
            }
            public static long perioada(long a1,long p1) {// Afla solutia nenula, daca exista, a ecuatiei a * x = 0 modulo p.
            	                   if(Clasa_de_resturi.e_valid(p1)) {
            	                     if(Clasa_de_resturi.result(a1,p1)==0) {
            	                	    return 1;
            	                        }
            	                     else {long aux,pi=p1;
            	                          while(a1!=0) {
            	                        	   if(a1<=p1/2) {
            	                        		 ;
            	                        	   }
            	                        	   else {
            	                        		    a1=Clasa_de_resturi.complement(a1, p1);
            	                        	        }
            	                        	   p1=Clasa_de_resturi.result(p1,a1);
            	                        	   aux=p1;
            	                        	   p1=a1;
            	                        	   a1=aux;
            	                               }
            	                        return pi/p1;
            	                        }
            	                   }
            	                   else {
            	                	   throw Clasa_de_resturi.aruncare_exceptie(p1);
            	                   }
            }
            public long perioada() {// Afla solutia nenula, daca exista, a ecuatiei a * x = 0 modulo p.
            	   return Clasa_de_resturi.perioada(a,p);
            }
            public static long cmmdc(long a1,long b1) {// Afla cel mai mare divizor comun a numerelor a1 si b1.
            	if(Clasa_de_resturi.e_valid(java.lang.Math.max(a1, b1))) {
            	  return java.lang.Math.max(a1,b1)/Clasa_de_resturi.perioada(java.lang.Math.min(a1,b1), java.lang.Math.max(a1,b1));
                  }
            	else {
            		throw new java.lang.ArithmeticException("Cel putin unul dintre numere e strict mai mare decat "+Clasa_de_resturi.pmax+'.');
            	}
            }
            public long cmmdc() {//Afla cel mai mare divizor comun a numerelor a si p.
            	return java.lang.Math.max(a,p)/perioada(java.lang.Math.min(a,p), java.lang.Math.max(a,p));
            }
            public static long cmmmc(long a1,long b1) {// Afla cel mai mic multiplu comun a numerelor a1 si b1.
            	if(Clasa_de_resturi.e_valid(java.lang.Math.max(a1, b1))) {
            	  return Clasa_de_resturi.perioada(java.lang.Math.min(a1,b1),java.lang.Math.max(a1,b1))*java.lang.Math.min(a1,b1);
                }
            	else {
            		throw new java.lang.ArithmeticException("Cel putin unul dintre numere e strict mai mare decat "+Clasa_de_resturi.pmax+'.');
            	}
            }
            public long cmmmc() {//Afla cel mai mic multiplu comun a numerelor a si p.
            	return Clasa_de_resturi.perioada(java.lang.Math.min(a,p),java.lang.Math.max(a,p))*java.lang.Math.min(a,p);
            }
            public static boolean admite_inversa(long a1,long p1) {// Determina daca o clasa de resturi modulo p1 admite inversa.
            	if(Clasa_de_resturi.e_valid(p1)){
            	  if(Clasa_de_resturi.perioada(a1, p1)==p1) {
            		 return true;
            	    }
            	  else{
            		  return false;
            	      }
            	}
            	else {
            		throw Clasa_de_resturi.aruncare_exceptie(p1);
            	}
            }
            public boolean admite_inversa() {// Determina daca o clasa de resturi modulo p1 admite inversa.
            	if(Clasa_de_resturi.perioada(a, p)==p) {
            		return true;
            	}
            	else{
            		return false;
            	}
            }
            public static long invers(long a1,long p1) {// Determina inversul, daca exista, a clasei de resturi a1 modulo p1.
            	if(Clasa_de_resturi.e_valid(p1))
            	  {a1=Clasa_de_resturi.result(a1, p1);
            	  if(Clasa_de_resturi.perioada(a1, p1)==p1) {
            	    if(Clasa_de_resturi.result(a1, p1)==p1-1) {
            		  return p1-1;
            	      }
            	    else {
            		     if(Clasa_de_resturi.result(a1, p1)==1) {
            		       return 1;
            	         }
            		     else {
            			     //Testul 1
            			     //return (Clasa_de_resturi.opus(Clasa_de_resturi.invers(Clasa_de_resturi.result(p1, a1), a1),a1)*p1+1)/a1;
            			     //Testul 2
            			     if(a1<=p1/2) {
            			     //  return (Clasa_de_resturi.result((a1-1)*Clasa_de_resturi.invers(Clasa_de_resturi.result(p1, a1), a1),a1)*p1+1)/a1;
            			   	  return (Clasa_de_resturi.opus(Clasa_de_resturi.invers(Clasa_de_resturi.result(p1, a1), a1),a1)*p1+1)/a1;  
            			      }
            			      else {
            			    	   return Clasa_de_resturi.opus(Clasa_de_resturi.invers(Clasa_de_resturi.opus(a1, p1), p1), p1);
            			           }
            		          }
            	         }
                    }
                  else {
            	       System.out.println("Clasa de resturi "+a1+" modulo "+p1+" nu admite inversa.");
            	       return -1;
                       }}
            	else{
            		throw Clasa_de_resturi.aruncare_exceptie(p1);
            	}
            }
            public long invers() { // Determina inversul, daca exista, a clasei de resturi a1 modulo p1.
            	if(Clasa_de_resturi.perioada(a, p)==p) {
            	   return Clasa_de_resturi.invers(a,p);
            	   }
                else {
                      System.out.println("Clasa de resturi "+a+" modulo "+p+" nu admite inversa.");
                      return 0;
                     }
            }
            public static long obtine_numarul_de_elemente(long a1,long p1) {// Calculeaza card(Im(a1,p1)).
            	if(!Clasa_de_resturi.e_valid(p1)) {
            		throw Clasa_de_resturi.aruncare_exceptie(p1);
            	}
            	else {
            	     return Clasa_de_resturi.perioada(a1,p1);
            	     }
            }
            public long obtine_numarul_de_elemente() {//Calculeaza card(Im(a,p)).
            	return perioada(a,p);
            }
            public static boolean e_in_im(long b,long a1,long p1) {// Determina daca b e in Im(a1,p1).
            	if(!Clasa_de_resturi.e_valid(p1)){
            		throw Clasa_de_resturi.aruncare_exceptie(p1);
            		}
            	else{
            		if(Clasa_de_resturi.result(Clasa_de_resturi.result(b, p1),Clasa_de_resturi.cmmdc(a1, p1))!=0) {
            			return false;
            			}
            		else {
            			return true;
            			}}
            }
            public boolean e_in_im(long b) {//Determina daca b e in Im(a,p).
            	if(Clasa_de_resturi.result(b,cmmdc())!=0) {
            		return false;
            	}
            	else {
            		return true;
            	}
            }
            public static long determina_prima_solutie_a_ecuatiei(long a1,long b1,long p1) {
            	if(!Clasa_de_resturi.e_valid(p1)){
            		throw Clasa_de_resturi.aruncare_exceptie(p1); 
            		}
            	else{
            		if(Clasa_de_resturi.e_in_im(b1, a1, p1)==false) {
            			return -1;
            		}
            		else {
            			a1=Clasa_de_resturi.result(a1, p1);
            			b1=Clasa_de_resturi.result(b1, p1);
            			long Tap=Clasa_de_resturi.perioada(a1, p1),r=p1/Tap,ir=b1/r,Tra=a1/r,inv=Clasa_de_resturi.invers(Tra, Tap);
            			return Clasa_de_resturi.result(ir*inv, Tap);
            			}
            		}
            }
            public long determina_prima_solutie_a_ecuatiei(long b) {
            	if(e_in_im(b)) {
            	  long Tap=perioada(),r=p/Tap,ir=b/r,Tra=a/r,inv=Clasa_de_resturi.invers(Tra, Tap);
        		  return Clasa_de_resturi.result(ir*inv, Tap);
            	}
            	else {
            		return -1;
            	}
            }
            public static java.util.LinkedList<Long> rezolva_ecuatia(long a1,long b1,long p1) {
            	if(!Clasa_de_resturi.e_valid(p1)){
            		throw Clasa_de_resturi.aruncare_exceptie(p1);
            	}
            	else{
            		a1=Clasa_de_resturi.result(a1, p1);
            		b1=Clasa_de_resturi.result(b1, p1);
            		java.util.LinkedList<Long> v=new java.util.LinkedList<Long>();
            		if(Clasa_de_resturi.e_in_im(b1, a1, p1)==false) {
            			v.add((long)-1);
            			}
            		else {
            			long Tap=Clasa_de_resturi.perioada(a1, p1),r=p1/Tap,ps=Clasa_de_resturi.determina_prima_solutie_a_ecuatiei(a1, b1, p1);
            			for(long i=0;i<r;i+=1) {
            				v.add(i*Tap+ps);
            				}
            			}
            		return v;
            		}
            }
            public java.util.LinkedList<Long> rezolva_ecuatia(long b) {
            	b=Clasa_de_resturi.result(b, p);
            	java.util.LinkedList<Long> v=new java.util.LinkedList<Long>();
            	if(Clasa_de_resturi.e_in_im(b, a, p)==false) {
            	    v.add((long)-1);
            	}
            	else {
               	     long Tap=Clasa_de_resturi.perioada(a, p),r=p/Tap,ps=Clasa_de_resturi.determina_prima_solutie_a_ecuatiei(a, b, p);
            	     for(long i=0;i<r;i+=1) {
            	    	 v.add(i*Tap+ps);
            	     }
                }
            	return v;
            }
            public static long perioada_patratului(long a1, long p1){
            	if(Clasa_de_resturi.e_valid(p1)){
            		a1=Clasa_de_resturi.result(a1, p1);
            		if(a1==0){
            			return 1;
            		}
            		else{
            			long T=Clasa_de_resturi.perioada(a1, p1), m=T*a1/p1;
            			return Clasa_de_resturi.perioada(m*a1,T);
            		}
            	}
            	else{
            		throw Clasa_de_resturi.aruncare_exceptie(p1);
            	}
            }
            public long perioada_patratului(){
            	if(a==0){
            		return 1;
            	}
            	else{
            		long T=perioada(), m=T*a/p;
            		return Clasa_de_resturi.perioada(m*a,T);
            		}
            }
            /*public static long perioada_de_ordinul_n(long a1, long p1, long n){// De verificat daca exista perioada pentru numere strict negative.
            	if(Clasa_de_resturi.e_valid(p1)){
            		if(n==1){
                		return Clasa_de_resturi.perioada(a1,p1);
                		}
                	else{
                		if(n==0){
                			throw new java.lang.ArithmeticException();
                			}
                		else{
                			if(n<0){
                				if(Clasa_de_resturi.admite_inversa(a1,p1)){
                					return p1;
                					}
                				else{
                					throw new java.lang.ArithmeticException("Clasa de resturi "+a1+" modulo "+p1+" nu admite inversa.");
                				}
                			}
                		}
                	}
            		a1=Clasa_de_resturi.result(a1, p1);
            		if(a1==0){
            			return 1;
            		}
            		else{
            			long T=Clasa_de_resturi.perioada(a1, p1), m=T*a1/p1;
            			a1=(long)java.lang.Math.pow(a1, n-1);
            			a1=Clasa_de_resturi.result(a1, p1);
            			return Clasa_de_resturi.perioada(m*a1,T);
            		}
            	}
            	else{
            		throw Clasa_de_resturi.aruncare_exceptie(p1);
            	}
            }
            public long perioada_de_ordinul_n(long n){// De verificat daca exista perioada pentru numere strict negative.
            	if(n==1){
            		return perioada();
            		}
            	else{
            		if(n==0){
            			throw new java.lang.ArithmeticException();
            			}
            		else{
            			if(n<0){
            				if(admite_inversa()){
            					return p;
            					}
            				else{
            					throw new java.lang.ArithmeticException("Clasa de resturi "+a+" modulo "+p+" nu admite inversa.");
            				}
            			}
            		}
            		}
            	if(a==0){
            		return 1;
            		}
            	else{
            		long T=perioada(), m=T*a/p;
            		seta((long)java.lang.Math.pow(a, n-1));
            		return Clasa_de_resturi.perioada(m*a,T);
            		}
            }*/
}
