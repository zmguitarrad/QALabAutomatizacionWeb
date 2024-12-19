@loginTiendaOnline
Feature: Product - Store

  Scenario: Validacion del precio de un producto
    Given estoy en la pagina de la tienda
    And me logueo con mi usuario "zamy2308guit@gmail.com" y clave "Zamy12345@"
    When navego a la categoria "Clothes" y subcategoria "Men"
    And agrego 2 unidades del primer producto al carrito
    Then valido en el popup la confirmacion del producto agregado
    When finalizo la compra
    Then valido el titulo de la pagina del carrito
    And vuelvo a validar el calculo de precios en el carrito

  Scenario: Login con un usuario invalido
    Given estoy en la página de la tienda
    When ingreso mi usuario "test@gmail.com" y clave "Test"
    Then muestra un mensaje de error "Error de autenticación."

  Scenario: Validación de categoria de productos
    Given estoy en la pagina de la tienda
    When me logueo con mi usuario "zamy2308guit@gmail.com" y clave "Zamy12345@"
    And  busco la categoria "Autos"
    Then muestra un mensaje de error "No se han encontrado coincidencias con tu búsqueda"

