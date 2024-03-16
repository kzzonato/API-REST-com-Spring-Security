<body>
  <main>
    <h1 align="center">☕ API com Spring Security e JWT 🍃</h1>
    <p>Sintaxe simples de uma API utilizando o Spring Security com JWT (auth0). Para utilizar a API o usuário tem que estar registrado no sistema e assim que ele logar, recebe um 
     token para validar esse usuário, se o usuário tiver a ROLE "ADMIN" ele pode usar certas funções do sistema destinadas para administradores, e se tiver a role "USER" ele 
     ficará restrito a algumas funções onde ele terá autorização de usar. A validação do usuário será feita através de tokens (JWT) já que a API é STATELESS.</p>
    <h3>Dependências utilizadas no projeto</h2>
    <ul>
      <li>Spring Security</li>
      <li>JWT</li>
      <li>Spring JPA</li>
      <li>Spring WEB</li>
      <li>Spring Validation</li>
      <li>PostgreSQL Driver</li>
      <li>FlyWay</li>
      <li>Lombok</li>
      <li>Maven</li>
    </ul>
    <h3>Tecnologias utilizadas</h3>
    <ul>
      <li>Java 21 lts</li>
      <li>Maven</li>
      <li>Spring Boot 3.2.3</li>
    </ul>
  </main>
</body>
