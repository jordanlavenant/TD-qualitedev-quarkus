
# Development Quality - Order Flow

A comprehensive DDD, CQRS, event-driven application for customer's order and stock management.

This application stack is designed for integrating into an ecosystem needing generic customer and order management.

## Installation

### Dev environment

This software project is designed to be run in a Docker environment. It uses devcontainer specification to provide a consistent development environment.

To run this project in a dev environment, you need to have Docker and Docker Compose installed on your machine.

1. Clone the repository
2. Open the project in Visual Studio Code / IntelliJ IDEA or any other IDE that supports devcontainer.
3. Open the project in the devcontainer.

Supported IDEs :
- Visual Studio Code
- IntelliJ IDEA

#### Pre-requisites

- Docker
- Docker Compose
- Visual Studio Code / IntelliJ IDEA
- Java 17+ (included)
- Gradle 7.3+ (included)
- Node.js 22+ (included)
- pnpm 9.6+ (included)

#### Mono-repository

This project is a mono-repository. It contains multiple packages that are designed to work together.

Libraries :
- `libs/core` : the core business package, containing the core business logic
- `libs/infrastructure` : the infrastructure package, containing the infrastructure logic
- `libs/shared` : the common package, containing common business logic

Applications :
- `apps/api-gateway` : the API gateway, exposing the core business logic as an HTTP API
- `apps/order-microservice` : the order microservice, exposing order business logic as an HTTP API
- `apps/stock-microservice` : the stock microservice, exposing stock business logic as an HTTP API
- `apps/cart-microservice` : the cart microservice, exposing cart business logic as an HTTP API

## Features

This application allows to manage cart (see here item lists), processing orders and observe and manage item stock.
This application does not cover customer management nor order delivery processing.

### Cart management

**Core subdomain**

Allow management of cart, which is a list of items that a customer wants to buy.
It also handles transmitting item locking, which is the process of reserving items in stock for a customer.

Cart is a set of AggregateRoot CartItem.

CartItem is composed of :
- Item : the item that is in cart
- Quantity : the quantity of the item in cart

Cart can have following states :
- Open : the cart is open. Items can be added or removed. This is the default state.
- Closed : the cart is closed. Items cannot be added or removed. Happens when the cart is confirmed.
- Archived : the cart is archived. This is the default state of a cart that staled for too long. It allows customers to keep an history of their unemptied carts.

Cart can receive following commands :
- AddItem : add an item to the cart.
- RemoveItem : remove an item from the cart.
- Clear : remove all items from the cart.

Cart can have following events :
- ItemAdded : an item has been added to the cart.
- ItemRemoved : an item has been removed from the cart.
- Cleared : all items have been removed from the cart.

Basic rules :
- Cart can be cleared at any time.
- Cart can be closed at any time.
- Cart is archived after a certain time of inactivity.
- Cart can be reopened after being archived.

### Order processing

**Core subdomain**

Allow management of order life-cycle.

Order is a set of AggregateRoot OrderItem.

OrderItem is composed of :
- Item : the item that is in order
- Quantity : the quantity of the item in order

Orders can have following states :
- Pending : the order is created but not confirmed yet.
- Confirmed : the order is confirmed. All necessary informations have been given and confirmed (ex: customer's informations collected and payment done)
- Processing : the order is being prepared, items collected, packages, etc.
- Shipped : the order has been shipped and is heading to customer. 
- Delivered : the order has been delivered to customer.
- Cancelled : the order has been cancelled.
- Returned : the order has been returned by customer.
- Completed : the order has been completed. This is the nominal final state of an order.
- Failed : the order has failed. This is the final state of an order.

Service can receive following commands :
- CreateOrder : create the order.

Orders can receive following commands :
- Start : start processing the order.
- Ship : ship the order.
- ConfirmDelivery : confirm the delivery of the order.
- Cancel : cancel the order.
- ConfirmReturn : confirm the return of the order.
- Complete : complete the order.
- ConfirmFailure : confirm the failure of the order.

Orders can have following events :
- Confirmed : the order has been confirmed.
- Processed : the order has been processed.
- Shipped : the order has been shipped.
- Delivered : the order has been delivered.
- Cancelled : the order has been cancelled.
- Returned : the order has been returned.
- Completed : the order has been completed.
- Failed : the order has failed.

Basic rules :
- Orders is created from a cart.
- Orders can be cancelled until they are shipped.
- Orders can be returned until they are completed.

### Stock management

**Core subdomain**

Allow management of stock.

The stock is the list of items that are available for sale.
This is a simplified model.

Stock is a set of AggregateRoot StockItem.

StockItem is composed of :
- Item : the item that is in stock
- Units : available units of the item
- ItemLocks : the list of item locks that are currently active for this item

There is a strong relation between units and item locks.

StockItem can have following states :
- Available : the item is available for sale.
- Locked : the item is locked and not available for sale.

StockService can receive following commands :
- AddItem : add an item to the stock.
- RemoveItem : remove an item from the stock.

StockItem can receive following commands :
- LockUnit : lock an item.
- UnlockUnit : unlock an item.
- ShipUnit : ship an item.
- RemoveUnit : remove a unit from the stock.

Basic rules :
- When an item is locked, it is not available for sale anymore.
- When an item is ordered, it is locked until the associated order is shipped.
- When an order is shipped, the item is unlocked and unit is removed.
- When an order is cancelled, the item is unlocked and unit is restored.
- When an item is returned, the item is unlocked and unit is restored.

## Documentation

[Go to index](./doc/index.md)

TODO

## Installation

TODO
    
## Authors

- Thibaud FAURIE :
  - [@thibaud.faurie (Private GitLab)](https://gitlab.cloud0.openrichmedia.org/thibaud.faurie)
  - [@thibaud-faurie (LinkedIn)](https://www.linkedin.com/in/thibaud-faurie/)

