export interface User {
  id: number;
  name: string;
  cpf: string;
  dateOfBirthday: Date;
  email: string;
  userType: string;
  phoneNumber: string;
  password: string;
  address: Address;
}

export interface Address{
    id: number;
    cep: string;
    rua: string;
    bairro: string;
    numero: string;
    complemento: string;
    cidade: string;
    uf: string;
    
}
